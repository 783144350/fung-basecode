package fung.umeng.param;

public class UPushPolicy {

    /**
     * 可选，定时发送时，若不填写表示立即发送。
     * 定时发送时间不能小于当前时间
     * 格式: "yyyy-MM-dd HH:mm:ss"。
     * 注意，start_time只对任务生效。
     */
    private String start_time;

    /**
     * 可选，消息过期时间，其值不可小于发送时间或者
     * start_time(如果填写了的话)，
     * 如果不填写此参数，默认为3天后过期。格式同start_time
     */
    private String expire_time;

    /**
     * 可选，发送限速，每秒发送的最大条数。最小值1000
     * 开发者发送的消息如果有请求自己服务器的资源，可以考虑此参数。
     */
    private Integer max_send_num;

    /**
     * 可选，开发者对消息的唯一标识，服务器会根据这个标识避免重复发送。
     * 有些情况下（例如网络异常）开发者可能会重复调用API导致
     * 消息多次下发到客户端。如果需要处理这种情况，可以考虑此参数。
     * 注意, out_biz_no只对任务生效。
     */
    private String out_biz_no;

    public String getStart_time() {
        return start_time;
    }

    public UPushPolicy setStart_time(String start_time) {
        this.start_time = start_time;
        return this;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public UPushPolicy setExpire_time(String expire_time) {
        this.expire_time = expire_time;
        return this;
    }

    public Integer getMax_send_num() {
        return max_send_num;
    }

    public UPushPolicy setMax_send_num(Integer max_send_num) {
        this.max_send_num = max_send_num;
        return this;
    }

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public UPushPolicy setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
        return this;
    }
}
