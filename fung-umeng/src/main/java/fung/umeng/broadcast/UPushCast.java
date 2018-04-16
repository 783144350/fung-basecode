package fung.umeng.broadcast;

import fung.umeng.UPushCallback;
import fung.umeng.filter.UPushFilter;
import fung.umeng.param.UPushAfterOpen;
import fung.umeng.param.UPushDisplayType;
import fung.umeng.param.UPushParam;
import fung.umeng.param.UPushType;

public interface UPushCast {

    void send();
    void send(UPushCallback callback);

    String getParamJSON();
    UPushParam getParam();

    UPushCast setTimestamp(String timestamp);
    UPushCast setType(UPushType type);
    UPushCast setDeviceTokens(String tokens);
    UPushCast setAliasType(String aliasType);
    UPushCast setAlias(String alias);
    UPushCast setDisplayType(UPushDisplayType displayType);
    UPushCast setFileId(String fileId);
    UPushCast setFilter(UPushFilter filter);
    UPushCast setTicker(String ticker);
    UPushCast setTitle(String title);
    UPushCast setText(String text);
    UPushCast setAfterOpen(UPushAfterOpen afterOpen);
    UPushCast setCustom(Object custom);
    UPushCast setStartTime(String startTime);
    UPushCast setExpireTime(String expireTime);
    UPushCast setMaxSendNum(Integer maxSendNum);
    UPushCast setOutBizNo(String outBizNo);
    UPushCast setProductionMode(String productionMode);
    UPushCast setDescription(String description);
    UPushCast setMiPush(String miPush);
    UPushCast setMiActivity(String miActivity);
    UPushCast setAppMasterSecret(String appMasterSecret);

    String getAppMasterSecret();
    String getAlias();

}
