package fung.umeng.test.broadcast;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import fung.umeng.broadcast.UPushCast;
import fung.umeng.broadcast.UPushCustomizedCast;
import fung.umeng.broadcast.UPushGroupCast;
import fung.umeng.broadcast.UPushMessage;
import fung.umeng.broadcast.UPushNotification;
import fung.umeng.broadcast.UPushUnicast;
import fung.umeng.filter.UPushFilter;
import fung.umeng.filter.UPushFilterAnd;
import fung.umeng.filter.UPushFilterAppVersion;
import fung.umeng.filter.UPushFilterTag;
import fung.umeng.test.MyMessage;

public class UPushCastTest {

    @Test
    public void testGroupCast() {
        new UPushGroupCast(
                new UPushNotification("my-app-key", "my-app-master-secret"))
                .setFilter(new UPushFilter()
                        .setWhere(new UPushFilterAnd()
                                .addCondition(new UPushFilterAppVersion()
                                        .setApp_version("1.0"))
                                .addCondition(new UPushFilterTag()
                                        .setTag("my-filter-tag"))))
                .setTicker("ticker")
                .setTitle("title")
                .setText("text")
                .setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setExpireTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setMaxSendNum(1000)
                .setDescription("fung test")
                .send();
        //groupCast.setDeviceTokens("my-device-token");

        UPushCast unicastNotify = new UPushUnicast(
                new UPushNotification("my-app-key", "my-app-master-secret"))
                .setDeviceTokens("my-device-token")
                .setTicker("ticker")
                .setTitle("title")
                .setText("text");
        System.out.println(unicastNotify.getParamJSON());

        UPushCast unicastMessage = new UPushUnicast(
                new UPushMessage("my-app-key", "my-app-master-secret")
                        .setDeviceTokens("my-device-token")
                        .setCustom(new MyMessage().setCode(0).setMsg("Hello Umeng")));
        System.out.println(unicastMessage.getParamJSON());

        UPushCast customizedCast = new UPushCustomizedCast(
                new UPushNotification("my-app-key", "my-app-master-secret"))
                .setAliasType("my-alias-type")
                .setAlias("my-alias");
        System.out.println(customizedCast.getParamJSON());
    }

}
