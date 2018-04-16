package fung.umeng.test.util;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import fung.umeng.UPushCallback;
import fung.umeng.UPushResponse;
import fung.umeng.filter.UPushFilter;
import fung.umeng.param.UPushPolicy;
import fung.umeng.util.SimpleCastBuilder;
import fung.umeng.util.SimpleFilterBuilder;
import fung.umeng.util.SimplePolicyBuilder;

import static fung.umeng.util.SimpleFilterBuilder.appVersion;
import static fung.umeng.util.SimpleFilterBuilder.channel;
import static fung.umeng.util.SimpleFilterBuilder.deviceModel;
import static fung.umeng.util.SimpleFilterBuilder.or;

public class SimpleCastTest {

    private static final String APP_KEY = "5a98be818f4a9d4000000130";
    private static final String APP_MASTER_SECRET = "svbia95rgcsty9tyrmrrgfyb7vbn9noy";

    @Test
    public void testSimpleBroadcast() {

        UPushFilter filter = new SimpleFilterBuilder()
                .build(or(appVersion("v1.0"), appVersion("v2.0")), channel("京东"), deviceModel("π盒"));

        UPushPolicy policy = new SimplePolicyBuilder()
                .setStartTime("2018-4-12 00:00:00")
                .setExpireTime("2018-4-12 12:12:12")
                .setMaxSendNum(1000)
                .build();

        new SimpleCastBuilder(SimpleCastBuilder.GROUP_CAST_NOTIFICATION, APP_KEY, APP_MASTER_SECRET)
                .setTitle("Hello")
                .setText("你好！")
                .setFilter(filter)
                .setPolicy(policy)
                .build()
                .send();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCallback() {
        new SimpleCastBuilder(SimpleCastBuilder.GROUP_CAST_NOTIFICATION, APP_KEY, APP_MASTER_SECRET)
                .setTitle("Hello")
                .setText("你好！")
                .build()
                .send(new UPushCallback() {
                    @Override
                    public void onFailure(IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(UPushResponse response) throws IOException {
                        if (response.getRet().equals("SUCCESS")) {
                            System.out.println("推送成功，任务号：" + response.getData());
                        } else {
                            System.out.println("推送失败，错误信息：" + response.getData());
                        }
                    }
                });

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
