package fung.util.test.excelmaker;

import com.alibaba.fastjson.JSON;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import fung.util.excelhelper.ExcelMakeException;
import fung.util.excelhelper.ExcelMaker;
import fung.util.excelhelper.ExcelMakerFactory;
import fung.util.excelhelper.ExcelParseException;
import fung.util.excelhelper.ExcelParserFactory;

public class ExcelMakerTest {

    @Test
    public void testApachePOI() throws IOException {
        // 获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/template.xls";
        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("订单号");
        row.createCell(2).setCellValue("下单时间");
        row.createCell(3).setCellValue("个数");
        row.createCell(4).setCellValue("单价");
        row.createCell(5).setCellValue("订单金额");
        row.setHeightInPoints(30); // 设置行的高度

        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("NO00001");

        // 日期格式化
        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
        HSSFCreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle2.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        sheet.setColumnWidth(2, 20 * 256); // 设置列的宽度

        HSSFCell cell2 = row1.createCell(2);
        cell2.setCellStyle(cellStyle2);
        cell2.setCellValue(new Date());

        row1.createCell(3).setCellValue(2);

        // 保留两位小数
        HSSFCellStyle cellStyle3 = workbook.createCellStyle();
        cellStyle3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        HSSFCell cell4 = row1.createCell(4);
        cell4.setCellStyle(cellStyle3);
        cell4.setCellValue(29.5);

        // 货币格式化
        HSSFCellStyle cellStyle4 = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("华文行楷");
        font.setFontHeightInPoints((short)15);
        font.setColor(HSSFColor.RED.index);
        cellStyle4.setFont(font);

        HSSFCell cell5 = row1.createCell(5);
        cell5.setCellFormula("D2*E2");  // 设置计算公式

        // 获取计算公式的值
        HSSFFormulaEvaluator e = new HSSFFormulaEvaluator(workbook);
        cell5 = e.evaluateInCell(cell5);
        System.out.println(cell5.getNumericCellValue());

        workbook.setActiveSheet(0);
        workbook.write(outputStream);
        outputStream.close();
    }

    @Test
    public void testExcelMaker() throws ExcelMakeException {
        List<Student> data = new ArrayList<>();
        data.add(new Student().setName("fung").setAge(27).setBirthday(new Date()));
        data.add(new Student().setName("yan").setAge(26).setBirthday(new Date()));

        // 导出到桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        final String desktop = fsv.getHomeDirectory().getPath();
        File file = new File(desktop, "students.xls");

        ExcelMakerFactory.getInstance().make(file, data);

        System.out.println("ok");

    }

    @Test
    public void testExcelParserAndMaker() throws IOException, ExcelParseException, ExcelMakeException {
        Resource resource = new ClassPathResource("students.xls", ExcelMakerTest.class);

        List<Student> students = ExcelParserFactory.getInstance().parse(resource.getFile(), Student.class);

        System.out.println(JSON.toJSONString(students));

        students.add(new Student().setName("哈哈").setAge(0).setBirthday(new Date()));

        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/students2.xls";
        File file = new File(filePath);
        ExcelMakerFactory.getInstance().make(file, students);

        System.out.println("ok");

    }

}
