package fung.util.excelhelper;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class ExcelMakerDelegate<T> {

    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private List<T> data;

    public ExcelMakerDelegate(HSSFWorkbook workbook, List<T> data) {
        if (data == null) {
            throw new NullPointerException("数据不能为空");
        }
        this.workbook = workbook;
        this.data = data;
    }

    public void make() throws ExcelMakeException {

        this.sheet = workbook.createSheet("Sheet1");

        if (!data.isEmpty()) {
            initHeader(data.get(0));
        }

        for (int index = 0; index < data.size(); index++) {
            T item = data.get(index);
            Class<?> clazz = item.getClass();
            HSSFRow row = sheet.createRow(index + 1);
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(ExcelHead.class)) {
                    ExcelHead annotation = field.getAnnotation(ExcelHead.class);
                    final int cellIndex = annotation.index();
                    HSSFCell cell = row.createCell(cellIndex);

                    writeDataToExcel(cell, getFieldValue(item, field), field.getType());
                }
            }
        }

    }

    private Object getFieldValue(T item, Field field) throws ExcelMakeException {
        try {
            Method method = item.getClass().getMethod("get" + upperCaseFirstLetter(field.getName()));
            return method.invoke(item);
        } catch (Exception e) {
            throw new ExcelMakeException("反射获取属性值出错，属性名：" + field.getName(), e);
        }

    }

    private void writeDataToExcel(HSSFCell cell, Object data, Class<?> type) {
        if (type.equals(String.class)) {
            cell.setCellValue((String)data);
        } else if (type.equals(int.class) || type.equals(Integer.class)) {
            cell.setCellValue((Integer)data);
        } else if (type.equals(long.class) || type.equals(Long.class)) {
            cell.setCellValue((Long)data);
        } else if (type.equals(float.class) || type.equals(Float.class)) {
            cell.setCellValue((Float)data);
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            cell.setCellValue((Double)data);
        } else if (type.equals(Date.class)) {
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            HSSFCreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue((Date)data);
        }
        else {
            throw new IllegalArgumentException("暂不支持数据类型：" + type);
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

    private void initHeader(T firstItem) throws ExcelMakeException {
        Class<?> clazz = firstItem.getClass();
        HSSFRow head = sheet.createRow(0);
        head.setHeightInPoints(30);

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ExcelHead.class)) {
                ExcelHead annotation = field.getAnnotation(ExcelHead.class);
                final String mappedHeadName = annotation.value();
                final int index = annotation.index();
                if (index < 0) {
                    throw new ExcelMakeException("注解中必须设置Index属性，且Index必须为非负数");
                }
                head.createCell(index).setCellValue(mappedHeadName);
            }
        }
    }

}
