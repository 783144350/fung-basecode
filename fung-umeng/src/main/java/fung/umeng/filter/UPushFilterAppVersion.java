package fung.umeng.filter;

public class UPushFilterAppVersion extends UPushFilterCondition {
    private String app_version;

    public String getApp_version() {
        return app_version;
    }

    public UPushFilterAppVersion setApp_version(String app_version) {
        this.app_version = app_version;
        return this;
    }
}
