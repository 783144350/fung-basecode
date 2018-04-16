package fung.umeng;

public class UPushResponse {

    private String ret;
    private String data;

    public String getRet() {
        return ret;
    }

    public UPushResponse setRet(String ret) {
        this.ret = ret;
        return this;
    }

    public String getData() {
        return data;
    }

    public UPushResponse setData(String data) {
        this.data = data;
        return this;
    }
}
