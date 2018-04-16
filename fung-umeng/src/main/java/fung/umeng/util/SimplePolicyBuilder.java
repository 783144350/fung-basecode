package fung.umeng.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import fung.umeng.param.UPushPolicy;

public class SimplePolicyBuilder {

    private UPushPolicy policy;

    public SimplePolicyBuilder() {
        policy = new UPushPolicy();
    }

    public SimplePolicyBuilder setStartTime(Date date) {
        policy.setStart_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        return this;
    }

    public SimplePolicyBuilder setStartTime(String date) {
        policy.setStart_time(date);
        return this;
    }

    public SimplePolicyBuilder setExpireTime(Date date) {
        policy.setExpire_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        return this;
    }

    public SimplePolicyBuilder setExpireTime(String date) {
        policy.setExpire_time(date);
        return this;
    }

    public SimplePolicyBuilder setMaxSendNum(Integer maxSendNum) {
        policy.setMax_send_num(maxSendNum);
        return this;
    }

    public SimplePolicyBuilder setOutBizNo(String outBizNo) {
        policy.setOut_biz_no(outBizNo);
        return this;
    }

    public UPushPolicy build() {
        return policy;
    }
}
