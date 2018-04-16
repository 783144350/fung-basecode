package fung.umeng.filter;

import java.util.ArrayList;
import java.util.List;

public class UPushFilterOr extends UPushFilterCondition {

    private List<UPushFilterCondition> or = new ArrayList<>();

    public UPushFilterOr addCondition(UPushFilterCondition condition) {
        or.add(condition);
        return this;
    }

    public List<UPushFilterCondition> getOr() {
        return or;
    }

    public UPushFilterOr setOr(List<UPushFilterCondition> or) {
        this.or = or;
        return this;
    }
}
