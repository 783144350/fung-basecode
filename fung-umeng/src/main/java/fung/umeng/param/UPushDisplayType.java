package fung.umeng.param;

public enum UPushDisplayType {

    NOTIFICATION("notification"),
    MESSAGE("message");

    private String type;

    UPushDisplayType(String type) {
        this.type = type;
    }

    public String value() {
        return type;
    }

}
