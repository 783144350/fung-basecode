package fung.umeng.filter;

public class UPushFilterNot extends UPushFilterCondition {

    private UPushFilterCondition not;

    public UPushFilterCondition getNot() {
        return not;
    }

    public UPushFilterNot setNot(UPushFilterCondition not) {
        this.not = not;
        return this;
    }
}
