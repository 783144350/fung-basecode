package fung.umeng.util;

import fung.umeng.filter.UPushEnumCountry;
import fung.umeng.filter.UPushEnumProvince;
import fung.umeng.filter.UPushFilter;
import fung.umeng.filter.UPushFilterAnd;
import fung.umeng.filter.UPushFilterAppVersion;
import fung.umeng.filter.UPushFilterChannel;
import fung.umeng.filter.UPushFilterCondition;
import fung.umeng.filter.UPushFilterCountry;
import fung.umeng.filter.UPushFilterDeviceModel;
import fung.umeng.filter.UPushFilterLanguage;
import fung.umeng.filter.UPushFilterLaunchFrom;
import fung.umeng.filter.UPushFilterNot;
import fung.umeng.filter.UPushFilterNotLaunchFrom;
import fung.umeng.filter.UPushFilterOr;
import fung.umeng.filter.UPushFilterProvince;
import fung.umeng.filter.UPushFilterTag;

public class SimpleFilterBuilder {

    private UPushFilter filter;
    private UPushFilterAnd root;

    public static UPushFilterCondition and(UPushFilterCondition... conditions) {
        UPushFilterAnd uPushFilterAnd = new UPushFilterAnd();
        for (UPushFilterCondition condition : conditions) {
            uPushFilterAnd.addCondition(condition);
        }
        return uPushFilterAnd;
    }

    public static UPushFilterCondition or(UPushFilterCondition... conditions) {
        UPushFilterOr uPushFilterOr =  new UPushFilterOr();
        for (UPushFilterCondition condition : conditions) {
            uPushFilterOr.addCondition(condition);
        }
        return uPushFilterOr;
    }

    public static UPushFilterCondition not(UPushFilterCondition condition) {
        return new UPushFilterNot().setNot(condition);
    }

    /**
     * 应用版本
     */
    public static UPushFilterCondition appVersion(String version) {
        return new UPushFilterAppVersion().setApp_version(version);
    }

    /**
     * 渠道
     */
    public static UPushFilterCondition channel(String channel) {
        return new UPushFilterChannel().setChannel(channel);
    }

    /**
     * 设备型号
     */
    public static UPushFilterCondition deviceModel(String model) {
        return new UPushFilterDeviceModel().setDevice_model(model);
    }

    /**
     * 省
     */
    public static UPushFilterCondition province(UPushEnumProvince province) {
        return new UPushFilterProvince().setProvince(province);
    }

    /**
     * 用户标签
     */
    public static UPushFilterCondition tag(String tag) {
        return new UPushFilterTag().setTag(tag);
    }

    /**
     * 国家和地区
     */
    public static UPushFilterCondition country(UPushEnumCountry country) {
        return new UPushFilterCountry().setCountry(country);
    }

    /**
     * 语言
     */
    public static UPushFilterCondition language(String language) {
        return new UPushFilterLanguage().setLanguage(language);
    }

    /**
     * 一段时间内活跃
     */
    public static UPushFilterCondition launchFrom(String launchFrom) {
        return new UPushFilterLaunchFrom().setLaunch_from(launchFrom);
    }

    /**
     * 一段时间内不活跃
     */
    public static UPushFilterCondition notLaunchFrom(String notLaunchFrom) {
        return new UPushFilterNotLaunchFrom().setNot_launch_from(notLaunchFrom);
    }

    public SimpleFilterBuilder() {
        root = new UPushFilterAnd();
        filter = new UPushFilter().setWhere(root);
    }

    public UPushFilter build(UPushFilterCondition... conditions) {
        for (UPushFilterCondition condition : conditions) {
            root.addCondition(condition);
        }
        return filter;
    }

}
