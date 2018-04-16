package fung.umeng.test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import fung.umeng.filter.UPushFilter;
import fung.umeng.param.UPushPolicy;
import fung.umeng.util.SimpleCastBuilder;
import fung.umeng.util.SimpleFilterBuilder;
import fung.umeng.util.SimplePolicyBuilder;

import static fung.umeng.util.SimpleFilterBuilder.channel;

public class UPushTest {

    private static final String APP_KEY = "5ab306dbb27b0a29a70007d3";
    private static final String APP_MASTER_SECRET = "ueovzjce8rbxgag4ilrxwivxmyp3njg0";

    @Test
    public void testUnicastNotification() {

        new SimpleCastBuilder(SimpleCastBuilder.UNICAST_NOTIFICATION, APP_KEY, APP_MASTER_SECRET)
                .setTitle("Hello")
                .setText("单播推送！")
                .setDeviceTokens("123456")
                .build()
                .send();

        wait4();
    }

    @Test
    public void testGroupCastNotification() {
        UPushFilter filter = new SimpleFilterBuilder()
                .build(channel("30001"));

        UPushPolicy policy = new SimplePolicyBuilder()
                .setStartTime("2018-4-11 00:00:00")
                .setExpireTime("2018-4-12 12:12:12")
                .setMaxSendNum(1000)
                .build();

        new SimpleCastBuilder(SimpleCastBuilder.GROUP_CAST_NOTIFICATION, APP_KEY, APP_MASTER_SECRET)
                .setTitle("Hello")
                .setText("组播推送！")
                .setFilter(filter)
//                .setPolicy(policy)
                .printPostBody()
                .build()
                .send();

        wait4();
    }

    @Test
    public void testCustomizedCastNotification() {

        final String aliaType = "System Control";
        final String[] alias = { "0", "0330773000117460000016", "0330773000117460000018", "2", "3" };

        SimpleCastBuilder builder = new SimpleCastBuilder(SimpleCastBuilder.CUSTOMIZED_CAST_NOTIFICATION, APP_KEY, APP_MASTER_SECRET)
                .setTitle("appclean")
                .setText("{ \"appclean\":[ \"com.xinli001.fm.xiaomi\", \"com.android.test\" ] }")
                .setAliasType(aliaType);

        for (String alia : alias) {
            builder.addAlia(alia);
        }

        builder.printPostBody()
                .build()
                .send();

        wait4();
    }

    @Test
    public void testBroadcastNotification() {

        new SimpleCastBuilder(SimpleCastBuilder.BROADCAST_NOTIFICATION, APP_KEY, APP_MASTER_SECRET)
                .setTitle("Hello")
                .setText("全播测试")
                .printPostBody()
                .build()
                .send();

        wait4();

    }

    private void wait4() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
