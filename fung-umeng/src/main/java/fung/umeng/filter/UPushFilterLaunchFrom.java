package fung.umeng.filter;

public class UPushFilterLaunchFrom extends UPushFilterCondition {

    private String launch_from;

    public String getLaunch_from() {
        return launch_from;
    }

    public UPushFilterLaunchFrom setLaunch_from(String launch_from) {
        this.launch_from = launch_from;
        return this;
    }
}
