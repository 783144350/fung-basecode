package fung.umeng.param;

public class UPushBody {

    /**
     * 必填，通知栏提示文字
     */
    private String ticker;

    /**
     * 必填，通知标题
     */
    private String title;

    /**
     * 必填，通知文字描述
     */
    private String text;

    /**
     * 可选，状态栏图标ID，R.drawable.[smallIcon],
     * 如果没有，默认使用应用图标。
     * 图片要求为24*24dp的图标，或24*24px放在drawable-mdpi下。
     * 注意四周各留1个dp的空白像素
     */
    private String icon;

    /**
     * 可选，通知栏拉开后左侧图标ID，R.drawable.[largeIcon]，
     * 图片要求为64*64dp的图标，
     * 可设计一张64*64px放在drawable-mdpi下，
     * 注意图片四周留空，不至于显示太拥挤
     */
    private String largeIcon;

    /**
     * 可选，通知栏大图标的URL链接。该字段的优先级大于largeIcon。
     * 该字段要求以http或者https开头。
     */
    private String img;

    /**
     * 自定义通知声音:
     * 可选，通知声音，R.raw.[sound]。
     * 如果该字段为空，采用SDK默认的声音，即res/raw/下的
     * umeng_push_notification_default_sound声音文件。如果
     * SDK默认声音文件不存在，则使用系统默认Notification提示音。
     */
    private String sound;

    /**
     * 自定义通知样式:
     * 可选，默认为0，用于标识该通知采用的样式。使用该参数时，
     * 开发者必须在SDK里面实现自定义通知栏样式。
     */
    private Integer builder_id;

    private String play_vibrate;
    private String play_lights;
    private String play_sound;

    /**
     * 点击"通知"的后续行为，默认为打开app。
     * 必填，值可以为:
     * "go_app": 打开应用
     * "go_url": 跳转到URL
     * "go_activity": 打开特定的activity
     * "go_custom": 用户自定义内容。
     */
    private String after_open;

    /**
     * 当after_open=go_url时，必填。
     * 通知栏点击后跳转的URL，要求以http或者https开头
     */
    private String url;

    /**
     * 当after_open=go_activity时，必填。
     * 通知栏点击后打开的Activity
     */
    private String activity;

    /**
     * 当display_type=message时, 必填
     * 当display_type=notification且
     * after_open=go_custom时，必填
     * 用户自定义内容，可以为字符串或者JSON格式。
     */
    private Object custom;

    public String getTicker() {
        return ticker;
    }

    public UPushBody setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UPushBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public UPushBody setText(String text) {
        this.text = text;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public UPushBody setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public UPushBody setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
        return this;
    }

    public String getImg() {
        return img;
    }

    public UPushBody setImg(String img) {
        this.img = img;
        return this;
    }

    public String getSound() {
        return sound;
    }

    public UPushBody setSound(String sound) {
        this.sound = sound;
        return this;
    }

    public Integer getBuilder_id() {
        return builder_id;
    }

    public UPushBody setBuilder_id(Integer builder_id) {
        this.builder_id = builder_id;
        return this;
    }

    public String getPlay_vibrate() {
        return play_vibrate;
    }

    public UPushBody setPlay_vibrate(String play_vibrate) {
        this.play_vibrate = play_vibrate;
        return this;
    }

    public String getPlay_lights() {
        return play_lights;
    }

    public UPushBody setPlay_lights(String play_lights) {
        this.play_lights = play_lights;
        return this;
    }

    public String getPlay_sound() {
        return play_sound;
    }

    public UPushBody setPlay_sound(String play_sound) {
        this.play_sound = play_sound;
        return this;
    }

    public String getAfter_open() {
        return after_open;
    }

    public UPushBody setAfter_open(UPushAfterOpen after_open) {
        this.after_open = after_open.value();
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UPushBody setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getActivity() {
        return activity;
    }

    public UPushBody setActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public Object getCustom() {
        return custom;
    }

    public UPushBody setCustom(Object custom) {
        this.custom = custom;
        return this;
    }
}
