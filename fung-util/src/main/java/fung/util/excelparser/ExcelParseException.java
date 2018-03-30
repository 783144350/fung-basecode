package fung.util.excelparser;

public class ExcelParseException extends Exception {

    public ExcelParseException(String msg) {
        super(msg);
    }

    public ExcelParseException(String msg, Throwable e) {
        super(msg, e);
    }

}
