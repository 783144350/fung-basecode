package fung.umeng.param;

public enum UPushAfterOpen {

    GO_APP("go_app"),
    GO_URL("go_url"),
    GO_ACTIVITY("go_activity"),
    GO_CUSTOM("go_custom");

    private String go;

    UPushAfterOpen(String go) {
        this.go = go;
    }

    public String value() {
        return go;
    }

}
