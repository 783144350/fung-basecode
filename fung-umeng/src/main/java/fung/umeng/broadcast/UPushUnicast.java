package fung.umeng.broadcast;

import fung.umeng.param.UPushParam;
import fung.umeng.param.UPushType;

public class UPushUnicast extends UPushDecorator {

    public UPushUnicast(UPushCast uPushCast) {
        super(uPushCast);
    }

    @Override
    public String getParamJSON() {
        getBroadcast().setType(UPushType.UNICAST);
        return super.getParamJSON();
    }

    public UPushCast setDeviceTokens(String tokens) {
        getBroadcast().setDeviceTokens(tokens);
        return this;
    }

    private UPushParam getInnerBroadcastParam() {
        return getBroadcast().getParam();
    }

}
