package fung.umeng;

import com.alibaba.fastjson.JSON;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import fung.umeng.broadcast.UPushCast;
import fung.umeng.exception.UmengException;
import fung.umeng.util.OkHttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UPushClient {

    // The host
    private static final String HOST = "http://msg.umeng.com";

    // The post path
    private static final String POST_PATH = "/api/send";

    public void send(UPushCast broadcast) {

        final String postBody = broadcast.getParamJSON();

        final String url = generateFinalUrl(generateSign(postBody,
                broadcast.getAppMasterSecret()));

        OkHttpUtil.enqueuePostJson(url, postBody, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }

        });

    }

    public void send(UPushCast broadcast, final UPushCallback callback) {

        final String postBody = broadcast.getParamJSON();

        final String url = generateFinalUrl(generateSign(postBody,
                broadcast.getAppMasterSecret()));

        OkHttpUtil.enqueuePostJson(url, postBody, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json = response.body().string();
                UPushResponse uPushResponse = JSON.parseObject(json, UPushResponse.class);
                callback.onResponse(uPushResponse);
            }

        });
    }

    private String generateSign(String postBody, String masterSecret) {
        try {
            final String url = HOST + POST_PATH;
            return DigestUtils.md5Hex(("POST" + url + postBody + masterSecret).getBytes("utf8"));
        } catch (UnsupportedEncodingException e) {
            throw new UmengException("生成sign是出现异常", e);
        }
    }

    private String generateFinalUrl(String sign) {
        return HOST + POST_PATH + "?sign=" + sign;
    }

}
