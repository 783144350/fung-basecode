package fung.umeng.broadcast;

import fung.umeng.exception.UmengException;
import fung.umeng.filter.UPushFilter;
import fung.umeng.param.UPushType;

public class UPushGroupCast extends UPushDecorator {

    public UPushGroupCast(UPushCast uPushCast) {
        super(uPushCast);
    }

    @Override
    public UPushCast setFilter(UPushFilter filter) {
        getBroadcast().setFilter(filter);
        return this;
    }

    @Override
    public String getParamJSON() {
        getBroadcast().setType(UPushType.GROUPCAST);
        return super.getParamJSON();
    }

    @Override
    public UPushCast setDeviceTokens(String tokens) {
        throw new UmengException("UPushGroupCast类中不允许使用setDeviceTokens方法");
    }

}
