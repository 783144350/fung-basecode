package fung.java.test.util;

import com.alibaba.fastjson.JSON;
import com.skyworthdigital.excel.ExcelMakeException;
import com.skyworthdigital.excel.ExcelMakerFactory;
import com.skyworthdigital.excel.ExcelParseException;
import com.skyworthdigital.excel.ExcelParser;
import com.skyworthdigital.excel.ExcelParserFactory;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.swing.filechooser.FileSystemView;


public class ExcelParserTest {

    @Test
    public void testExcelParser() throws IOException, ExcelParseException {
        Resource resource = new ClassPathResource("test.xls", ExcelParserTest.class);

        List<Model> result = new ExcelParser().parse(resource.getFilename(),
                resource.getInputStream(), Model.class);

        System.out.println("解析结果：" + JSON.toJSONString(result));
    }

    @Test
    public void testExcelFactory() throws IOException, ExcelParseException {
        Resource resource = new ClassPathResource("test.xlsx", ExcelParserTest.class);

        List<Model2> result = ExcelParserFactory.getInstance().parse(resource.getFile(), Model2.class);

        System.out.println("解析结果：" + JSON.toJSONString(result));
    }

    @Test
    public void testExcelParserAndMaker() throws IOException, ExcelParseException, ExcelMakeException {
        Resource resource = new ClassPathResource("students.xls", ExcelParserTest.class);

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
