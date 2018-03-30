package fung.util.excelparser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class ExcelParser {

    public static final int EDITION_2003 = 2003;
    public static final int EDITION_2007 = 2007;

    public Object parse(String fileName, InputStream in, Class clazz) throws IOException {
        if (fileName.endsWith("xls")) {
            return parse(EDITION_2003, in, clazz);
        } else if (fileName.endsWith("xlsx")) {
            return parse(EDITION_2007, in, clazz);
        } else {
            throw new IllegalArgumentException("请使用后缀名为xls或xlsx的excel文件");
        }
    }

    public Object parse(int edition, InputStream in, Class clazz) throws IOException {

        Workbook workbook = getWorkbook(edition, in);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();

        Row header = sheet.getRow(sheet.getFirstRowNum());
        

        return new Object();
    }

    private Workbook getWorkbook(int edition, InputStream in) throws IOException {
        if (edition == EDITION_2003) {
            return new HSSFWorkbook(in);
        } else if (edition == EDITION_2007) {
            return new XSSFWorkbook(in);
        } else {
            throw new IllegalArgumentException("该解析器仅支持解析Excel 2003或Excel 2007，不支持版本：" + edition);
        }
    }

}
