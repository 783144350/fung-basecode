package fung.util.excelhelper;

public class ExcelParserFactory {

    private ExcelParserFactory() {

    }

    private static ExcelParser instance;

    public static ExcelParser getInstance() {
        if (instance == null) {
            synchronized (ExcelParserFactory.class) {
                if (instance == null) {
                    instance = new ExcelParser();
                }
            }
        }
        return instance;
    }

}
