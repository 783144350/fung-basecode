package fung.umeng.broadcast;

import fung.umeng.exception.UmengException;
import fung.umeng.param.UPushType;

public class UPushCustomizedCast extends UPushDecorator {

    public UPushCustomizedCast(UPushCast broadcast) {
        super(broadcast);
    }

    @Override
    public String getParamJSON() {
        getBroadcast().setType(UPushType.CUSTOMIZEDCAST);
        return super.getParamJSON();
    }

    @Override
    public UPushCast setDeviceTokens(String tokens) {
        throw new UmengException("UPushCustomizedCast类中不允许使用setDeviceTokens方法");
    }

}
