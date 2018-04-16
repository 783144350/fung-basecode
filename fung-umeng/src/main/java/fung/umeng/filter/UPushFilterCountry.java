package fung.umeng.filter;

public class UPushFilterCountry extends UPushFilterCondition {

    private String country;

    public String getCountry() {
        return country;
    }

    public UPushFilterCountry setCountry(UPushEnumCountry country) {
        this.country = country.value();
        return this;
    }
}
