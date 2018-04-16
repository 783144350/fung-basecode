package fung.umeng.param;

import fung.umeng.filter.UPushFilter;

public class UPushParam {

    /**
     * 必填，应用唯一标识
     */
    private String appkey;

    /**
     * 必填，时间戳，10位或者13位均可，时间戳有效期为10分钟
     */
    private String timestamp;

    /**
    * 必填，消息发送类型,其值可以为:
    * unicast-单播
    * listcast-列播，要求不超过500个device_token
    * filecast-文件播，多个device_token可通过文件形式批量发送
    * broadcast-广播
    * groupcast-组播，按照filter筛选用户群, 请参照filter参数
    * customizedcast，通过alias进行推送，包括以下两种case:
    *   - alias: 对单个或者多个alias进行推送
    *   - file_id: 将alias存放到文件后，根据file_id来推送
    */
    private String type;

    /**
     * 当type=unicast时, 必填, 表示指定的单个设备
     * 当type=listcast时, 必填, 要求不超过500个, 以英文逗号分隔
     */
    private String device_tokens;

    /**
     * 当type=customizedcast时, 必填
     * alias的类型, alias_type可由开发者自定义, 开发者在SDK中
     * 调用setAlias(alias, alias_type)时所设置的alias_type
     */
    private String alias_type;

    /**
     * 当type=customizedcast时, 选填(此参数和file_id二选一)
     * 开发者填写自己的alias, 要求不超过500个alias, 多个alias以英文逗号间隔
     * 在SDK中调用setAlias(alias, alias_type)时所设置的alias
     */
    private String alias;

    /**
     * 当type=filecast时，必填，file内容为多条device_token，以回车符分割
     * 当type=customizedcast时，选填(此参数和alias二选一)
     * file内容为多条alias，以回车符分隔。注意同一个文件内的alias所对应
     * 的alias_type必须和接口参数alias_type一致。
     * 使用文件播需要先调用文件上传接口获取file_id，参照"2.4文件上传接口"
     */
    private String file_id;

    /**
     * 当type=groupcast时，必填，用户筛选条件，如用户标签、渠道等，参考附录G。
     */
    private UPushFilter filter;

    /**
     * 必填，JSON格式，具体消息内容(Android最大为1840B)
     */
    private UPushPayload payload;

    /**
     * 可选，发送策略
     */
    private UPushPolicy policy;

    /**
     * 可选，正式/测试模式。默认为true
     * 测试模式只会将消息发给测试设备。测试设备需要到web上添加。
     * Android: 测试设备属于正式设备的一个子集。
     */
    private String production_mode;

    /**
     * 可选，发送消息描述，建议填写。
     */
    private String description;

    /**
     * 可选，默认为false。当为true时，表示MIUI、EMUI、Flyme系统设备离线转为系统下发
     */
    private String mipush;

    /**
     * 可选，mipush值为true时生效，表示走系统通道时打开指定页面acitivity的完整包路径。
     */
    private String mi_activity;

    public String getAppkey() {
        return appkey;
    }

    public UPushParam setAppkey(String appkey) {
        this.appkey = appkey;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public UPushParam setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getType() {
        return type;
    }

    public UPushParam setType(UPushType type) {
        this.type = type.value();
        return this;
    }

    public String getDevice_tokens() {
        return device_tokens;
    }

    public UPushParam setDevice_tokens(String device_tokens) {
        this.device_tokens = device_tokens;
        return this;
    }

    public String getAlias_type() {
        return alias_type;
    }

    public UPushParam setAlias_type(String alias_type) {
        this.alias_type = alias_type;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public UPushParam setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getFile_id() {
        return file_id;
    }

    public UPushParam setFile_id(String file_id) {
        this.file_id = file_id;
        return this;
    }

    public UPushFilter getFilter() {
        return filter;
    }

    public UPushParam setFilter(UPushFilter filter) {
        this.filter = filter;
        return this;
    }

    public UPushPayload getPayload() {
        return payload;
    }

    public UPushParam setPayload(UPushPayload payload) {
        this.payload = payload;
        return this;
    }

    public UPushPolicy getPolicy() {
        return policy;
    }

    public UPushParam setPolicy(UPushPolicy policy) {
        this.policy = policy;
        return this;
    }

    public String getProduction_mode() {
        return production_mode;
    }

    public UPushParam setProduction_mode(String production_mode) {
        this.production_mode = production_mode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UPushParam setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMipush() {
        return mipush;
    }

    public UPushParam setMipush(String mipush) {
        this.mipush = mipush;
        return this;
    }

    public String getMi_activity() {
        return mi_activity;
    }

    public UPushParam setMi_activity(String mi_activity) {
        this.mi_activity = mi_activity;
        return this;
    }
}
