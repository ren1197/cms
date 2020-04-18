package com.gx.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class WordFilterUtils {
    private static final String API = "https://aip.baidubce.com/rest/2.0/antispam/v2/spam?access_token=";

    public enum Label {
        LABEL1("暴力反恐", 1),
        LABEL2("文本色情", 2),
        LABEL3("政治敏感", 3),
        LABEL4("恶意推广", 4),
        LABEL5("低俗辱骂", 5),
        LABEL6("低质灌水", 6);

        private String label;
        private int index;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static String getValue(int index) {
            for (Label c : Label.values()) {
                if (c.getIndex() == index) {
                    return c.label;
                }
            }
            return null;
        }

        Label(String label, int index) {
            this.label = label;
            this.index = index;
        }
    }

    public static class CheckedResult {
        private Integer code;
        private Map<String, String> notPassMap;
        private String msg;

        public static WordFilterUtils.CheckedResult success() {
            return new WordFilterUtils.CheckedResult().setCode(100);
        }

        public static WordFilterUtils.CheckedResult warn() {
            return new WordFilterUtils.CheckedResult().setCode(300);
        }

        public static WordFilterUtils.CheckedResult warn(Map<String ,String > notPassMap) {
            return new WordFilterUtils.CheckedResult().setCode(300).setNotPassMap(notPassMap);
        }


        public static WordFilterUtils.CheckedResult error() {
            return new WordFilterUtils.CheckedResult().setCode(500);
        }

        public static WordFilterUtils.CheckedResult error(String msg) {
            return new WordFilterUtils.CheckedResult().setMsg(msg).setCode(500);
        }

        public static WordFilterUtils.CheckedResult error(Map<String ,String > notPassMap) {
            return new WordFilterUtils.CheckedResult().setCode(500).setNotPassMap(notPassMap);
        }

        public Integer getCode() {
            return code;
        }

        public WordFilterUtils.CheckedResult setCode(Integer code) {
            this.code = code;
            return this;
        }

        public String getMsg() {
            return msg;
        }

        public WordFilterUtils.CheckedResult setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Map<String, String> getNotPassMap() {
            return notPassMap;
        }

        public WordFilterUtils.CheckedResult setNotPassMap(Map<String, String> notPassMap) {
            this.notPassMap = notPassMap;
            return this;
        }
    }


    public static WordFilterUtils.CheckedResult getWord(String content) throws Exception {
        String requestUrl = API + HttpUtils.getAuth();
        JSONObject result = JSONObject.parseObject(HttpClientUtil.post(requestUrl, "content=" + content));
        JSONObject obj = result.getJSONObject("result");
        if (obj == null) return CheckedResult.error("网络请求失败");
        System.out.println(JSON.toJSONString(obj));
        int spam=obj.getIntValue("spam");
        if (spam==0){
            return CheckedResult.success();
        }
        if (spam==1||spam==2){
            Map<String,String> map=new HashMap<>();
            JSONArray rejectArray=obj.getJSONArray("reject");
            for (int i=0;i<rejectArray.size();i++){
                map.put(rejectArray.getJSONObject(i).getString("hit"),Label.getValue(rejectArray.getJSONObject(i).getIntValue("label")));
            }
            JSONArray reviewArray=obj.getJSONArray("review");
            for (int i=0;i<reviewArray.size();i++){
                map.put(reviewArray.getJSONObject(i).getString("hit"),Label.getValue(reviewArray.getJSONObject(i).getIntValue("label")));
            }
            return CheckedResult.warn(map);
        }
        return null;
    }
}
