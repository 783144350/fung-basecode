package fung.umeng.filter;

public class UPushFilterNotLaunchFrom extends UPushFilterCondition {

    private String not_launch_from;

    public String getNot_launch_from() {
        return not_launch_from;
    }

    public UPushFilterNotLaunchFrom setNot_launch_from(String not_launch_from) {
        this.not_launch_from = not_launch_from;
        return this;
    }
}
