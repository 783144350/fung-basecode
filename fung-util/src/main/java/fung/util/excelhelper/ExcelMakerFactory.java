package fung.util.excelhelper;

public class ExcelMakerFactory {

    private ExcelMakerFactory() {

    }

    private static ExcelMaker instance = new ExcelMaker();

    public static ExcelMaker getInstance() {
        return instance;
    }

}
