package com.gx.web.content;


import com.alibaba.fastjson.JSON;
import com.gx.utils.WordFilterUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("wordFilter")
@RequestMapping("wordFilter")
public class WordFilterController {

	@RequestMapping("checked")
	@ResponseBody
	public WordFilterUtils.CheckedResult checked(String content) throws Exception {
		WordFilterUtils.CheckedResult result=WordFilterUtils.getWord(content);
		System.out.println(JSON.toJSONString(result));
		return result;
	}
}
