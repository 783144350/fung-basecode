package fung.umeng.filter;

public class UPushFilter {

    // 筛选条件的最顶层必须为and
    private UPushFilterAnd where;

    public UPushFilterAnd getWhere() {
        return where;
    }

    public UPushFilter setWhere(UPushFilterAnd where) {
        this.where = where;
        return this;
    }
}
