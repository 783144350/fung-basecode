package fung.java.test.util;

import com.alibaba.fastjson.JSON;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.List;

import fung.util.excelparser.ExcelParseException;
import fung.util.excelparser.ExcelParser;
import fung.util.excelparser.ExcelParserFactory;


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

}
