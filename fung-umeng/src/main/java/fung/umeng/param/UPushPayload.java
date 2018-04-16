package fung.umeng.param;

public class UPushPayload {

    /**
     * 必填，消息类型: notification(通知)、message(消息)
     */
    private String display_type;

    /**
     * 必填，消息体。
     * 当display_type=message时，body的内容只需填写custom字段。
     * 当display_type=notification时，body包含如下参数:
     */
    private UPushBody body;

    public String getDisplay_type() {
        return display_type;
    }

    public UPushPayload setDisplay_type(UPushDisplayType display_type) {
        this.display_type = display_type.value();
        return this;
    }

    public UPushBody getBody() {
        return body;
    }

    public UPushPayload setBody(UPushBody body) {
        this.body = body;
        return this;
    }
}
