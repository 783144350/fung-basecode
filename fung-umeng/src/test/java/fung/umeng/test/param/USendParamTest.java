package fung.umeng.test.param;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import fung.umeng.filter.UPushFilterCountry;
import fung.umeng.filter.UPushFilterProvince;
import fung.umeng.param.UPushDisplayType;
import fung.umeng.filter.UPushFilter;
import fung.umeng.filter.UPushFilterAnd;
import fung.umeng.filter.UPushEnumCountry;
import fung.umeng.filter.UPushFilterOr;
import fung.umeng.param.UPushAfterOpen;
import fung.umeng.param.UPushPolicy;
import fung.umeng.param.UPushType;
import fung.umeng.param.UPushBody;
import fung.umeng.param.UPushParam;
import fung.umeng.param.UPushPayload;
import fung.umeng.filter.UPushEnumProvince;

public class USendParamTest {

    @Test
    public void testUPushParam() {
        System.out.println(JSON.toJSONString(
                new UPushParam()
                        .setAppkey("appkey")
                        .setTimestamp("timestamp")));
    }

    @Test
    public void testGroupCast() {

        UPushBody body = new UPushBody()
                .setTicker("ticker")
                .setTitle("title")
                .setText("text")
                .setAfter_open(UPushAfterOpen.GO_APP);
        UPushPayload payload = new UPushPayload()
                .setDisplay_type(UPushDisplayType.NOTIFICATION)
                .setBody(body);
        UPushPolicy policy = new UPushPolicy()
                .setStart_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setExpire_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .setMax_send_num(1000);
        UPushFilter filter = new UPushFilter()
                .setWhere(new UPushFilterAnd()
                        .addCondition(new UPushFilterOr()
                                .addCondition(new UPushFilterCountry()
                                        .setCountry(UPushEnumCountry.CHINA)))
                        .addCondition(new UPushFilterOr()
                                .addCondition(new UPushFilterProvince()
                                        .setProvince(UPushEnumProvince.BEI_JING))
                                .addCondition(new UPushFilterProvince()
                                        .setProvince(UPushEnumProvince.SHANG_HAI))));
        UPushParam param = new UPushParam()
                .setAppkey("appkey-12345")
                .setTimestamp(String.valueOf(new Date().getTime()))
                .setType(UPushType.GROUPCAST)
                .setPayload(payload)
                .setPolicy(policy)
                .setProduction_mode("false")
                .setDescription("test")
                .setFilter(filter);

        System.out.println(JSON.toJSONString(param));

    }

}
