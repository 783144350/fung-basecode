package fung.umeng.broadcast;

import fung.umeng.exception.UmengException;
import fung.umeng.param.UPushDisplayType;

public class UPushNotification extends UPushAbstractCast {

    public UPushNotification(String appKey, String appMasterSecret) {
        super(appKey, appMasterSecret);
        initParam();
    }

    @Override
    public String getParamJSON() {
        return super.getParamJSON();
    }

    @Override
    public UPushCast setCustom(Object custom) {
        throw new UmengException("UPushNotify类中，方法setCustom被禁用");
    }

    private void initParam() {
        setDisplayType(UPushDisplayType.NOTIFICATION);
    }

}
