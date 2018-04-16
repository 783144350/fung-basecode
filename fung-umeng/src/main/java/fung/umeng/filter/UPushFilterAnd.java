package fung.umeng.filter;

import java.util.ArrayList;
import java.util.List;

public class UPushFilterAnd extends UPushFilterCondition {

    private List<UPushFilterCondition> and = new ArrayList<>();

    public UPushFilterAnd addCondition(UPushFilterCondition condition) {
        and.add(condition);
        return this;
    }

    public List<UPushFilterCondition> getAnd() {
        return and;
    }

    public UPushFilterAnd setAnd(List<UPushFilterCondition> and) {
        this.and = and;
        return this;
    }
}
