package fung.umeng.param;

public enum UPushType {

    UNICAST("unicast"),
    LISTCAST("listcast"),
    FILECAST("filecast"),
    BROADCAST("broadcast"),
    GROUPCAST("groupcast"),
    CUSTOMIZEDCAST("customizedcast");

    private String type;

    UPushType(String type) {
        this.type = type;
    }

    public String value() {
        return type;
    }
}
