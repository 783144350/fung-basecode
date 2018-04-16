package fung.umeng.filter;

public enum UPushEnumProvince {

    BEI_JING("北京"),
    SHANG_HAI("上海");

    private String provinec;

    UPushEnumProvince(String province) {
        this.provinec = province;
    }

    public String value() {
        return provinec;
    }

}
