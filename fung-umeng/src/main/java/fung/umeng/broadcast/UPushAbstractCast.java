package fung.umeng.broadcast;

import com.alibaba.fastjson.JSON;

import fung.umeng.UPushCallback;
import fung.umeng.UPushClient;
import fung.umeng.filter.UPushFilter;
import fung.umeng.param.UPushAfterOpen;
import fung.umeng.param.UPushBody;
import fung.umeng.param.UPushDisplayType;
import fung.umeng.param.UPushParam;
import fung.umeng.param.UPushPayload;
import fung.umeng.param.UPushPolicy;
import fung.umeng.param.UPushType;

public abstract class UPushAbstractCast implements UPushCast {

    private UPushParam uPushParam = new UPushParam();
    private UPushPayload uPushPayload = new UPushPayload();
    private UPushBody uPushBody = new UPushBody();
    private UPushPolicy uPushPolicy = new UPushPolicy();

    private String appMasterSecret;

    public UPushAbstractCast() {

    }

    public UPushAbstractCast(String appKey, String appMasterSecret) {
        this.appMasterSecret = appMasterSecret;
        uPushParam.setAppkey(appKey);
        initParam();
    }

    @Override
    public UPushCast setType(UPushType type) {
        uPushParam.setType(type);
        return this;
    }

    @Override
    public UPushCast setTimestamp(String timestamp) {
        uPushParam.setTimestamp(timestamp);
        return this;
    }

    @Override
    public UPushCast setDisplayType(UPushDisplayType displayType) {
        uPushPayload.setDisplay_type(displayType);
        return this;
    }

    @Override
    public UPushCast setDeviceTokens(String tokens) {
        uPushParam.setDevice_tokens(tokens);
        return this;
    }

    @Override
    public UPushCast setAliasType(String aliasType) {
        uPushParam.setAlias_type(aliasType);
        return this;
    }

    @Override
    public UPushCast setAlias(String alias) {
        uPushParam.setAlias(alias);
        return this;
    }

    @Override
    public UPushCast setFileId(String fileId) {
        uPushParam.setFile_id(fileId);
        return this;
    }

    @Override
    public UPushCast setFilter(UPushFilter filter) {
        uPushParam.setFilter(filter);
        return this;
    }

    @Override
    public UPushCast setTicker(String ticker) {
        uPushBody.setTicker(ticker);
        return this;
    }

    @Override
    public UPushCast setTitle(String title) {
        uPushBody.setTitle(title);
        return this;
    }

    @Override
    public UPushCast setText(String text) {
        uPushBody.setText(text);
        return this;
    }

    @Override
    public UPushCast setAfterOpen(UPushAfterOpen afterOpen) {
        uPushBody.setAfter_open(afterOpen);
        return this;
    }

    @Override
    public UPushCast setCustom(Object custom) {
        uPushBody.setCustom(custom);
        return this;
    }

    @Override
    public UPushCast setStartTime(String startTime) {
        uPushPolicy.setStart_time(startTime);
        return this;
    }

    @Override
    public UPushCast setExpireTime(String expireTime) {
        uPushPolicy.setExpire_time(expireTime);
        return this;
    }

    @Override
    public UPushCast setMaxSendNum(Integer maxSendNum) {
        uPushPolicy.setMax_send_num(maxSendNum);
        return this;
    }

    @Override
    public UPushCast setOutBizNo(String outBizNo) {
        uPushPolicy.setOut_biz_no(outBizNo);
        return this;
    }

    @Override
    public UPushCast setProductionMode(String productionMode)  {
        uPushParam.setProduction_mode(productionMode);
        return this;
    }

    @Override
    public UPushCast setDescription(String description) {
        uPushParam.setDescription(description);
        return this;
    }

    @Override
    public UPushCast setMiPush(String miPush) {
        uPushParam.setMipush(miPush);
        return this;
    }

    @Override
    public UPushCast setMiActivity(String miActivity) {
        uPushParam.setMi_activity(miActivity);
        return this;
    }

    @Override
    public String getAlias() {
        return uPushParam.getAlias();
    }

    @Override
    public void send() {
        final String timestamp = Integer.toString((int)(System.currentTimeMillis() / 1000));
        setTimestamp(timestamp);
        new UPushClient().send(this);
    }

    @Override
    public void send(UPushCallback callback) {
        final String timestamp = Integer.toString((int)(System.currentTimeMillis() / 1000));
        setTimestamp(timestamp);
        new UPushClient().send(this, callback);
    }

    @Override
    public UPushCast setAppMasterSecret(String appMasterSecret) {
        this.appMasterSecret = appMasterSecret;
        return this;
    }

    @Override
    public String getAppMasterSecret() {
        return appMasterSecret;
    }

    public UPushParam getParam() {
        return uPushParam;
    }

    @Override
    public String getParamJSON() {
        return JSON.toJSONString(uPushParam);
    }

    private void initParam() {
        uPushParam.setPayload(uPushPayload);
        uPushPayload.setBody(uPushBody);
        uPushParam.setPolicy(uPushPolicy);
        uPushBody.setAfter_open(UPushAfterOpen.GO_APP);
        uPushParam.setTimestamp(Integer.toString((int)(System.currentTimeMillis() / 1000)));
    }

}
