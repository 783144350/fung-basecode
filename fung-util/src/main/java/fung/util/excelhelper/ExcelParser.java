package fung.util.excelhelper;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelParser {

    public static final int EDITION_2003 = 2003;
    public static final int EDITION_2007 = 2007;

    public <T> List<T> parse(File file, Class<T> clazz) throws ExcelParseException {

        try (InputStream in = new FileInputStream(file)) {
            return parse(file.getName(), in, clazz);
        } catch (FileNotFoundException e) {
            throw new ExcelParseException("文件不存在：" + file.getName(), e);
        } catch (IOException e) {
            throw new ExcelParseException("文件读取出错：" + file.getName(), e);
        }

    }

    public <T> List<T> parse(String fileName, InputStream in, Class<T> clazz) throws ExcelParseException {
        if (fileName.endsWith("xls")) {
            return parse(EDITION_2003, in, clazz);
        } else if (fileName.endsWith("xlsx")) {
            return parse(EDITION_2007, in, clazz);
        } else {
            throw new IllegalArgumentException("请使用后缀名为xls或xlsx的excel文件");
        }
    }

    public <T> List<T> parse(int edition, InputStream in, Class<T> clazz) throws ExcelParseException {
        try {
            Sheet sheet = getFirstSheet(edition, in);
            return new ExcelParserDelegate<>(sheet, clazz).parse();
        } catch (Exception e) {
            throw new ExcelParseException("Excel解析异常", e);
        }
    }

    private Sheet getFirstSheet(int edition, InputStream in) throws IOException {
        if (edition == EDITION_2003) {
            return new HSSFWorkbook(in).getSheetAt(0);
        } else if (edition == EDITION_2007) {
            return new XSSFWorkbook(in).getSheetAt(0);
        } else {
            throw new IllegalArgumentException("该解析器仅支持解析Excel 2003或Excel 2007，不支持版本：" + edition);
        }
    }

}
