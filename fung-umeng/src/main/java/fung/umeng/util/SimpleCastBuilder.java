package fung.umeng.util;

import fung.umeng.broadcast.UPushBroadcast;
import fung.umeng.broadcast.UPushCast;
import fung.umeng.broadcast.UPushCustomizedCast;
import fung.umeng.broadcast.UPushGroupCast;
import fung.umeng.broadcast.UPushMessage;
import fung.umeng.broadcast.UPushNotification;
import fung.umeng.broadcast.UPushUnicast;
import fung.umeng.exception.UmengException;
import fung.umeng.filter.UPushFilter;
import fung.umeng.param.UPushPolicy;

public class SimpleCastBuilder {

    public static final int GROUP_CAST_NOTIFICATION = 1;
    public static final int GROUP_CAST_MESSAGE = 2;
    public static final int UNICAST_NOTIFICATION = 3;
    public static final int UNICAST_MESSAGE = 4;
    public static final int CUSTOMIZED_CAST_NOTIFICATION = 5;
    public static final int CUSTOMIZED_CAST_MESSAGE = 6;
    public static final int BROADCAST_NOTIFICATION = 7;
    public static final int BROADCAST_MESSAGE = 8;


    private static final String ALIAS_SEPARATOR = ",";

    private UPushCast broadcast;

    public SimpleCastBuilder(int type, String appKey, String appMasterSecret) {
        switch (type) {
            case GROUP_CAST_NOTIFICATION:
                broadcast = new UPushGroupCast(new UPushNotification(appKey, appMasterSecret))
                        .setDescription("Group Cast Notification")
                        .setTicker("ticker");
                break;
            case GROUP_CAST_MESSAGE:
                broadcast = new UPushGroupCast(new UPushMessage(appKey, appMasterSecret))
                        .setDescription("Group Cast Message");
                break;
            case UNICAST_NOTIFICATION:
                broadcast = new UPushUnicast(new UPushNotification(appKey, appMasterSecret))
                        .setDescription("Unicast Notification")
                        .setTicker("ticker");
                break;
            case UNICAST_MESSAGE:
                broadcast = new UPushUnicast(new UPushMessage(appKey, appMasterSecret))
                        .setDescription("Unicast Message");
                break;
            case CUSTOMIZED_CAST_NOTIFICATION:
                broadcast = new UPushCustomizedCast(new UPushNotification(appKey, appMasterSecret))
                        .setDescription("Customized Notification")
                        .setTicker("ticker");
                break;
            case CUSTOMIZED_CAST_MESSAGE:
                broadcast = new UPushCustomizedCast(new UPushMessage(appKey, appMasterSecret))
                        .setDescription("Customized Message");
                break;
            case BROADCAST_NOTIFICATION:
                broadcast = new UPushBroadcast(new UPushNotification(appKey, appMasterSecret))
                        .setDescription("Broadcast Notification")
                        .setTicker("ticker");
                break;
            case BROADCAST_MESSAGE:
                broadcast = new UPushBroadcast(new UPushMessage(appKey, appMasterSecret))
                        .setDescription("Broadcast Message")
                        .setTicker("ticker");
                break;
            default:
                throw new UmengException("暂不支持类型：" + type);
        }
    }

    public SimpleCastBuilder setTitle(String title) {
        broadcast.setTitle(title);
        return this;
    }

    public SimpleCastBuilder setText(String text) {
        broadcast.setText(text);
        return this;
    }

    public SimpleCastBuilder setFilter(UPushFilter filter) {
        broadcast.setFilter(filter);
        return this;
    }

    public SimpleCastBuilder setCustom(Object custom) {
        broadcast.setCustom(custom);
        return this;
    }

    public SimpleCastBuilder setDeviceTokens(String tokens) {
        broadcast.setDeviceTokens(tokens);
        return this;
    }

    public SimpleCastBuilder setPolicy(UPushPolicy policy) {
        if (policy.getStart_time() != null) {
            broadcast.setStartTime(policy.getStart_time());
        }
        if (policy.getExpire_time() != null) {
            broadcast.setExpireTime(policy.getExpire_time());
        }
        if (policy.getMax_send_num() != null) {
            broadcast.setMaxSendNum(policy.getMax_send_num());
        }
        if (policy.getOut_biz_no() != null) {
            broadcast.setOutBizNo(policy.getOut_biz_no());
        }
        return this;
    }

    public SimpleCastBuilder setAliasType(String type) {
        broadcast.setAliasType(type);
        return this;
    }

    public SimpleCastBuilder setAlias(String alias) {
        broadcast.setAlias(alias);
        return this;
    }

    public SimpleCastBuilder addAlia(String alia) {
        String alias = broadcast.getAlias();
        if (alias == null) {
            alias = alia;
        } else {
            alias += ALIAS_SEPARATOR + alia;
        }
        broadcast.setAlias(alias);
        return this;
    }

    public SimpleCastBuilder printPostBody() {
        System.out.println("Post body: " + broadcast.getParamJSON());
        return this;
    }

    public UPushCast build() {
        return broadcast;
    }
}
