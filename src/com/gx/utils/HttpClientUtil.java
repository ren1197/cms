package com.gx.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;


import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HttpClientUtil {
    public static final String CONTENT_TYPE_DEFAULT = "application/x-www-form-urlencoded; charset=UTF-8";
    public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
    public static final String CONTENT_TYPE_DATA = "multipart/form-data";
    public static final int CONNECTION_TIME_OUT = 5000;
    public static final int CONNECTION_REQUEST_TIME_OUT = 5000;
    public static final int SOCKET_TIME_OUT = 5000;

    public static String post() {  
        return "";
    }

    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static HttpClientBuilder httpBuilder = null;
    public static RequestConfig requestConfig = null;

    private static int MAXCONNECTION = 10;

    private static int DEFAULTMAXCONNECTION = 5;

    public static String get(String url) {
        return "";
    }

    public static String get(String url, String params) {
        return "";
    }

    //请求参数param为json
    public static String post(String url, String json) throws Exception {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        String result = "";
        //设置请求头
        post.setHeader("Content-Type", CONTENT_TYPE_JSON);
        post.setEntity(new StringEntity(json, "utf-8"));
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, "utf-8");
            } else if (response.getStatusLine().getStatusCode() == 404) {
                throw new Exception("请求错误，错误码：" + response.getStatusLine().getStatusCode());
            } else {
                throw new Exception("请求错误，错误码：" + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String post(String url, Object params, String contentType) throws Exception {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        String result = "";
        //设置请求头
        post.setHeader("Content-Type", contentType);
        List<NameValuePair> list = new ArrayList<>();
        String jsonStr = JSON.toJSONString(params);
        StringEntity entity = new StringEntity(jsonStr, "utf-8");
        post.setEntity(entity);
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity responseEntity = response.getEntity();
                result = EntityUtils.toString(responseEntity, "utf-8");
            } else {
                throw new Exception("请求错误，错误码：" + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String jsonPost(String url, Map<String, Object> params) throws Exception {
        HttpPost post = new HttpPost(url);
        //设置请求头
        post.setHeader("Content-type", CONTENT_TYPE_JSON);
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(params), "utf-8");
        stringEntity.setContentType(CONTENT_TYPE_JSON);
        post.setEntity(stringEntity);
        return getResponseEntity(post);
    }


    public static String formPost(String url, Map<String, String> params) throws Exception {
        List<NameValuePair> nvpList = new ArrayList<>();
        for (String key : params.keySet()) {
            nvpList.add(new BasicNameValuePair(key, params.get(key)));
        }
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", CONTENT_TYPE_DEFAULT);
        try {
            post.setEntity(new UrlEncodedFormEntity(nvpList, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getResponseEntity(post);
    }

    //获取请求结果的两个方法1
    private static String getResponseEntity(HttpUriRequest request) throws Exception {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        String result = "";
        try {
            response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, "utf-8");
            } else {
                throw new Exception("请求错误" +
                        "\n错误码：" + response.getStatusLine().getStatusCode() +
                        "\n错误内容" + response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null)
                response.close();
            client.close();
        }
        return result;
    }

    //获取请求结果的两个方法2
    private static String getResponseEntity(HttpPost post) throws Exception {

        CloseableHttpClient client = HttpClientBuilder.create()
                .setKeepAliveStrategy(getConnectionKeepAliveStrategy())
                .build();
        CloseableHttpResponse response = null;
        String result = "";
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, "utf-8");
            } else {
                throw new Exception("请求错误" +
                        "\n错误码：" + response.getStatusLine().getStatusCode() +
                        "\n错误内容" + response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (HttpHostConnectException e) {
            e.printStackTrace();
            throw new Exception("连接失败，请检查网络！");
        } finally {
            if (response != null)
                response.close();
            client.close();
        }
        return result;
    }

    public static ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {

        return new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                Args.notNull(response, "HTTP response");
                final HeaderElementIterator it = new BasicHeaderElementIterator(
                        response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    final HeaderElement he = it.nextElement();
                    final String param = he.getName();
                    final String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase("timeout")) {
                        try {
                            return Long.parseLong(value) * 1000;
                        } catch (final NumberFormatException ignore) {
                        }
                    }
                }
                return 1;
            }
        };
    }
}
