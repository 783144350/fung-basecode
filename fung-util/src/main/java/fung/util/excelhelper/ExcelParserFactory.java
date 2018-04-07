package fung.util.excelhelper;

public class ExcelParserFactory {

    private ExcelParserFactory() {

    }

    private static ExcelParser instance = new ExcelParser();

    public static ExcelParser getInstance() {
        return instance;
    }

}
