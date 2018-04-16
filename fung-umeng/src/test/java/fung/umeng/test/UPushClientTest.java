package fung.umeng.test;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import fung.umeng.UPushCallback;
import fung.umeng.UPushClient;
import fung.umeng.UPushResponse;
import fung.umeng.broadcast.UPushCast;
import fung.umeng.broadcast.UPushGroupCast;
import fung.umeng.broadcast.UPushNotification;
import fung.umeng.filter.UPushFilter;
import fung.umeng.filter.UPushFilterAnd;
import fung.umeng.filter.UPushFilterAppVersion;
import fung.umeng.filter.UPushFilterTag;

public class UPushClientTest {

    @Test
    public void testUPushClient() {
        UPushCast broadcast = new UPushGroupCast(
                new UPushNotification("5a98be818f4a9d4000000130", "svbia95rgcsty9tyrmrrgfyb7vbn9noy"))
                .setFilter(new UPushFilter()
                        .setWhere(new UPushFilterAnd()
                                .addCondition(new UPushFilterAppVersion()
                                        .setApp_version("1.0"))
                                .addCondition(new UPushFilterTag()
                                        .setTag("my-filter-tag"))))
                .setTicker("ticker")
                .setTitle("title")
                .setText("text")
                .setMaxSendNum(1000)
                .setTimestamp(Integer.toString((int)(System.currentTimeMillis() / 1000)))
                .setDescription("fung test");

//        new UPushClient().send(broadcast);

        new UPushClient().send(broadcast, new UPushCallback() {
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
