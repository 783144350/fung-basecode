package fung.util.excelparser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExcelParserDelegate<T> {

    private Sheet sheet;
    private Row header;

    private Map<Integer, String> headerMap;

    private Class<T> clazz;

    public ExcelParserDelegate(Sheet sheet, Class<T> clazz) {
        this.sheet = sheet;
        this.header = sheet.getRow(sheet.getFirstRowNum());
        this.clazz = clazz;
    }

    public List<T> parse() throws ExcelParseException {

        // 初始化表头
        initHeaderMap();

        List<T> result = new ArrayList<>();

        final int rowNum = sheet.getLastRowNum();
        final int startIndex = sheet.getFirstRowNum() + 1;

        for (int rowIndex = startIndex; rowIndex <= rowNum; rowIndex++) {
            result.add(parseLine(rowIndex));
        }

        return result;
    }

    private void initHeaderMap() throws ExcelParseException {
        headerMap = new HashMap<>();
        for (int colIndex = header.getFirstCellNum(); colIndex < header.getLastCellNum(); colIndex++) {
            Cell cell = header.getCell(colIndex);
            if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                throw new ExcelParseException("请检查Excel表头字段，必须为字符串，列号：" + colIndex);
            }
            headerMap.put(colIndex, cell.getStringCellValue());
        }
    }

    private String upperCaseFirstLetter(String str) {
        if (str == null) {
            throw new NullPointerException("输入参数不能为空");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("输入参数不能为空字串");
        }
        return str.replace(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

    private T parseLine(int rowIndex) throws ExcelParseException {
        try {
            Row row = sheet.getRow(rowIndex);
            T model = clazz.getConstructor().newInstance();

            for (int colIndex = row.getFirstCellNum(); colIndex < row.getLastCellNum(); colIndex++) {

                final String excelHeadName = headerMap.get(colIndex);
                final String value = getCellValue(row.getCell(colIndex));

                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(ExcelHead.class)) {
                        ExcelHead annotation = field.getAnnotation(ExcelHead.class);
                        final String mappedHeadName = annotation.value();

                        if (mappedHeadName.equals(excelHeadName)) {
                            Method method = clazz.getMethod("set" + upperCaseFirstLetter(field.getName()),
                                    field.getType());
                            method.invoke(model, parseValue(value, field.getType()));
                        }
                    }
                }
            }

            return model;

        } catch (Exception e) {
            throw new ExcelParseException("解析Excel行：" + rowIndex + "出错", e);
        }
    }

    /**
     * 获取表格里数据，统一转化为String类型
     */
    private String getCellValue(Cell cell) {
        if (cell == null) {
            throw new NullPointerException("输入参数为空");
        }

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                return new BigDecimal(cell.getNumericCellValue()).toPlainString();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_FORMULA:
                return new BigDecimal(cell.getNumericCellValue()).toPlainString();
            case Cell.CELL_TYPE_BLANK:
                return  "";
            case Cell.CELL_TYPE_BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            default:
                throw new RuntimeException("Excel解析时，数据类型出错");
        }
    }

    private Object parseValue(String value, Class<?> type) {

        if (type.equals(String.class)) {
            return value;
        } else if (type.equals(int.class) || type.equals(Integer.class)) {
            return Integer.parseInt(value);
        } else if (type.equals(long.class) || type.equals(Long.class)) {
            return Long.parseLong(value);
        } else if (type.equals(boolean.class) || type.equals(Boolean.class))  {
            return Boolean.parseBoolean(value);
        } else if (type.equals(float.class) || type.equals(Float.class)) {
            return Float.parseFloat(value);
        } else {
            throw new IllegalArgumentException("暂不支持数据类型：" + type);
        }

    }

}
