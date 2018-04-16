package fung.umeng.broadcast;

import fung.umeng.exception.UmengException;
import fung.umeng.param.UPushAfterOpen;
import fung.umeng.param.UPushDisplayType;
import fung.umeng.param.UPushType;

public class UPushDecorator extends UPushAbstractCast {

    private UPushCast broadcast;

    public UPushDecorator(UPushCast broadcast) {
        this.broadcast = broadcast;
    }

    public UPushCast getBroadcast() {
        return broadcast;
    }

    @Override
    public String getParamJSON() {
        return broadcast.getParamJSON();
    }

    @Override
    public UPushCast setTimestamp(String timestamp) {
        broadcast.setTimestamp(timestamp);
        return this;
    }

    @Override
    public UPushCast setAliasType(String aliasType) {
        broadcast.setAliasType(aliasType);
        return this;
    }

    @Override
    public UPushCast setAlias(String alias) {
        broadcast.setAlias(alias);
        return this;
    }

    @Override
    public UPushCast setTicker(String ticker) {
        broadcast.setTicker(ticker);
        return this;
    }

    @Override
    public UPushCast setTitle(String title) {
        broadcast.setTitle(title);
        return this;
    }

    @Override
    public UPushCast setText(String text) {
        broadcast.setText(text);
        return this;
    }

    @Override
    public UPushCast setAfterOpen(UPushAfterOpen afterOpen) {
        broadcast.setAfterOpen(afterOpen);
        return this;
    }

    @Override
    public UPushCast setCustom(Object custom) {
        broadcast.setCustom(custom);
        return this;
    }

    @Override
    public UPushCast setStartTime(String startTime) {
        broadcast.setStartTime(startTime);
        return this;
    }

    @Override
    public UPushCast setExpireTime(String expireTime) {
        broadcast.setExpireTime(expireTime);
        return this;
    }

    @Override
    public UPushCast setMaxSendNum(Integer maxSendNum) {
        broadcast.setMaxSendNum(maxSendNum);
        return this;
    }

    @Override
    public UPushCast setOutBizNo(String outBizNo) {
        broadcast.setOutBizNo(outBizNo);
        return this;
    }

    @Override
    public UPushCast setProductionMode(String productionMode)  {
        broadcast.setProductionMode(productionMode);
        return this;
    }

    @Override
    public UPushCast setDescription(String description) {
        broadcast.setDescription(description);
        return this;
    }

    @Override
    public UPushCast setMiPush(String miPush) {
        broadcast.setMiPush(miPush);
        return this;
    }

    @Override
    public UPushCast setMiActivity(String miActivity) {
        broadcast.setMiActivity(miActivity);
        return this;
    }

    @Override
    public UPushCast setAppMasterSecret(String appMasterSecret) {
        broadcast.setAppMasterSecret(appMasterSecret);
        return this;
    }

    @Override
    public String getAppMasterSecret() {
        return broadcast.getAppMasterSecret();
    }

    @Override
    public String getAlias() {
        return broadcast.getAlias();
    }

    @Override
    public UPushCast setType(UPushType type) {
        throw new UmengException("UPushDecorator类中setType方法不被允许使用");
    }

    @Override
    public UPushCast setDisplayType(UPushDisplayType displayType) {
        throw new UmengException("UPushDecorator类中setDisplayType方法不被允许使用");
    }

}
