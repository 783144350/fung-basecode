package fung.umeng.filter;

public class UPushFilterProvince extends UPushFilterCondition {

    private String province;

    public String getProvince() {
        return province;
    }

    public UPushFilterProvince setProvince(UPushEnumProvince province) {
        this.province = province.value();
        return this;
    }

    public UPushFilterProvince setProvince(String province) {
        this.province = province;
        return this;
    }
}
