package fung.util.excelparser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelParser {

    public static final int EDITION_2003 = 2003;
    public static final int EDITION_2007 = 2007;

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

    private Map<String, Integer> getHeaderMap(Row header) {
        Map<String, Integer> headerMap = new HashMap<>();
        for (int colIndex = header.getFirstCellNum(); colIndex < header.getLastCellNum(); colIndex++) {
            Cell cell = header.getCell(colIndex);
            headerMap.put(cell.getStringCellValue(), colIndex);
        }
        return headerMap;
    }



}
