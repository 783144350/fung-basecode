package fung.umeng.filter;

public enum UPushEnumCountry {

    CHINA("中国");

    private String country;

    UPushEnumCountry(String country) {
        this.country = country;
    }

    public String value() {
        return country;
    }
}
