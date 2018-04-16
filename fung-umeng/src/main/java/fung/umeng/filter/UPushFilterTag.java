package fung.umeng.filter;

public class UPushFilterTag extends UPushFilterCondition {

    private String tag;

    public String getTag() {
        return tag;
    }

    public UPushFilterTag setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
