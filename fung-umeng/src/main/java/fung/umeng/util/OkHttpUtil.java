package fung.umeng.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

    private static final OkHttpClient mOkHttpClient;

    static{
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        mOkHttpClient = builder.readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 该不会开启异步线程。
     * @param request
     * @return
     * @throws IOException
     */
    private static Response execute(Request request) throws IOException{
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 使用get请求服务器
     * 该方法不会开启异步线程
     * @param url url地址
     * @return 服务器返回的response
     * @throws IOException
     */
    public static Response executeGet(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        return execute(request);
    }

    public static Response executePostJson(String url, String json) throws IOException {
        return execute(generateJsonRequest(url, json));
    }

    /**
     * 使用post请求服务器
     * 该方法不会开启异步线程
     * @param url url地址
     * @param keys 键列表
     * @param values 值列表
     * @return 服务器返回的response
     * @throws IOException
     */
    public static Response executePost(String url, String[] keys, String[] values) throws IOException {

        if (keys.length != values.length) {
            throw new IllegalArgumentException("the length of keys does not equal to the length of values");
        }

        FormBody.Builder builder = new FormBody.Builder();

        for (int i = 0; i < keys.length; i++) {
            builder.add(keys[i], values[i]);
        }

        RequestBody formBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        return execute(request);
    }

    /**
     * 开启异步线程访问网络
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request, Callback responseCallback){
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 开启异步线程，发送json字符串
     */
    public static void enqueuePostJson(String url, String json, Callback responseCallback) {
        mOkHttpClient.newCall(generateJsonRequest(url, json))
                .enqueue(responseCallback);
    }

    /**
     * 开启异步线程，发送json字符串
     * 且不在意返回结果（实现空callback）
     */
    public static void enqueuePostJson(String url, String json) {

        mOkHttpClient.newCall(generateJsonRequest(url, json))
                .enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }

        });
    }

    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     * @param request
     */
    public static void enqueue(Request request){
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }

        });
    }

    public static String getStringFromServer(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    private static Request generateJsonRequest(String url, String json) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json);

        return new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json; q=0.5")
                .post(requestBody)
                .build();
    }

}
