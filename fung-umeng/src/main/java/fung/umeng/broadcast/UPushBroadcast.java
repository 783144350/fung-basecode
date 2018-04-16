package fung.umeng.broadcast;

import fung.umeng.param.UPushType;

public class UPushBroadcast extends UPushDecorator {

    public UPushBroadcast(UPushCast broadcast) {
        super(broadcast);
    }

    @Override
    public String getParamJSON() {
        getBroadcast().setType(UPushType.BROADCAST);
        return super.getParamJSON();
    }

}
