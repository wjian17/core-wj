package com.knowledge.accumulation.utils.http;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by wj on 2017/9/22.
 */
public class OkHttp3Utils {

    public static int connectTimeout;
    public static int readTimeout;
    public static int writeTimeout;

    private static final Logger logger = LoggerFactory.getLogger(OkHttp3Utils.class);

    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient mOkHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)//设置超时时间
            .readTimeout(readTimeout, TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(writeTimeout, TimeUnit.SECONDS)//设置写入超时时间
            .build();



    public static String postJson(String url, String json, Map<String, String> headers) {
        //申明给服务端传递一个json串
        //创建一个OkHttpClient对象
//         okHttpClient = new OkHttpClient();
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.sslSocketFactory(TrustAllHostnameVerifier.createSSLSocketFactory(), new TrustAllCerts());
        clientBuilder.hostnameVerifier(new TrustAllHostnameVerifier());
        OkHttpClient okHttpClient = clientBuilder.build();
        //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, json);
        //创建一个请求对象
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);
                //.build();
        if(null != headers && headers.size() > 0){
            Set<String> headerKeys = headers.keySet();
            for(Iterator<String> ite = headerKeys.iterator(); ite.hasNext();){
                String key = ite.next();
                String value = headers.get(key);
                builder.addHeader(key, value);
            }
        }
        Request request = builder.build();
        //发送请求获取响应
        try {
            Response response=okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if(response.isSuccessful()){
                //打印服务端返回结果
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String post(String url, Map<String, Object> params)
            throws Exception {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if(null != entry.getKey() && null != entry.getValue()){
                String clazzName = value.getClass().getName();
                if(clazzName.equals("java.lang.String")){
                    builder.add(key, String.valueOf(value));
                }else{
                    builder.add(key, "" + value);
                }
            }
        }
        //生成表单实体对象
        FormBody formBody = builder.build();
        Request.Builder requestBuilder = new Request.Builder();

        final Request request = requestBuilder.url(url).post(formBody).build();
        //创建一个Call
        final Call call = mOkHttpClient.newCall(request);
        //执行请求
        Response response = call.execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }else{
            return null;
        }
    }

    public static String postForUrl(String url, Map<String, Object> params)
            throws Exception {
        //处理参数
        StringBuilder tempParams = new StringBuilder();
        int pos = 0;
        for (String key : params.keySet()) {
            if (pos > 0) {
                tempParams.append("&");
            }
            Object value = params.get(key);
            String clazzName = value.getClass().getName();
            if(clazzName.equals("java.lang.String")){
                tempParams.append(String.format("%s=%s", key, URLEncoder.encode(String.valueOf(value), "utf-8")));
            }else{
                tempParams.append(String.format("%s=%s", key, URLEncoder.encode(value + "", "utf-8")));
            }
            pos++;
        }
        //生成参数
        String paramsStr = tempParams.toString();
        //创建一个请求实体对象 RequestBody
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, paramsStr);
        Request.Builder requestBuilder = new Request.Builder();
        final Request request = requestBuilder.url(url + "?" + paramsStr).post(body).build();
        //创建一个Call
        final Call call = mOkHttpClient.newCall(request);
        //执行请求
        Response response = call.execute();
        //请求执行成功
        if (response.isSuccessful()) {
            //获取返回数据 可以是String，bytes ,byteStream
            return response.body().string();
        }else{
            return null;
        }
    }



}
