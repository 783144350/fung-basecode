package fung.umeng.broadcast;

import fung.umeng.exception.UmengException;
import fung.umeng.param.UPushDisplayType;

public class UPushMessage extends UPushAbstractCast {

    public UPushMessage(String appKey, String appMasterSecret) {
        super(appKey, appMasterSecret);
        initParam();
    }

    @Override
    public String getParamJSON() {
        return super.getParamJSON();
    }

    @Override
    public UPushCast setTicker(String ticker) {
        throw new UmengException("UPushMessage类中，方法setTicker被禁用");
    }

    @Override
    public UPushCast setTitle(String title) {
        throw new UmengException("UPushMessage类中，方法setTitle被禁用");
    }

    @Override
    public UPushCast setText(String text) {
        throw new UmengException("UPushMessage类中，方法setText被禁用");
    }

    private void initParam() {
        setDisplayType(UPushDisplayType.MESSAGE);
    }

}
