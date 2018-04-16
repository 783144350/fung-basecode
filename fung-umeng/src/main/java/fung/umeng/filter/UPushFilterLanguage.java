package fung.umeng.filter;

public class UPushFilterLanguage extends UPushFilterCondition {

    private String language;

    public String getLanguage() {
        return language;
    }

    public UPushFilterLanguage setLanguage(String language) {
        this.language = language;
        return this;
    }
}
