package fung.umeng.filter;

public class UPushFilterChannel extends UPushFilterCondition {

    private String channel;

    public String getChannel() {
        return channel;
    }

    public UPushFilterChannel setChannel(String channel) {
        this.channel = channel;
        return this;
    }
}
