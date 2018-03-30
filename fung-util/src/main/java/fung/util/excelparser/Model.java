package fung.util.excelparser;

public class Model {

    @ExcelHead(value = "订单号")
    private long order;

    @ExcelHead(value = "手机号码")
    private int phoneNum;

    @ExcelHead(value = "月份")
    private Integer month;

    @ExcelHead(value = "激活码")
    private String code;

    @ExcelHead(value = "短信页签")
    private String tag;

    public long getOrder() {
        return order;
    }

    public Model setOrder(long order) {
        this.order = order;
        return this;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public Model setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public Model setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Model setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Model setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
