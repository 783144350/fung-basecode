package fung.util.test.excelparser;

import com.alibaba.fastjson.JSON;
import fung.util.excelparser.ExcelParseException;
import fung.util.excelparser.ExcelParser;
import fung.util.excelparser.ExcelParserFactory;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public class ExcelParserTest {

    @Test
    public void testExcelParser() throws IOException, ExcelParseException {
        Resource resource = new ClassPathResource("test.xls", ExcelParserTest.class);
        ExcelParser parser = new ExcelParser();
        List<Model> result = parser.parse(resource.getFilename(), resource.getInputStream(), Model.class);
        System.out.println("解析结果：" + JSON.toJSONString(result));
    }

    @Test
    public void testExcelXParser() throws IOException, ExcelParseException {
        Resource resource = new ClassPathResource("test.xlsx", ExcelParserTest.class);

        List<Model2> result = new ExcelParser().parse(resource.getFile(), Model2.class);

        System.out.println("解析结果：" + JSON.toJSONString(result));
    }

    @Test
    public void testExcelFactory() throws IOException, ExcelParseException {
        Resource resource = new ClassPathResource("test.xlsx", ExcelParserTest.class);

        List<Model2> result = ExcelParserFactory.getInstance().parse(resource.getFile(), Model2.class);

        System.out.println("解析结果：" + JSON.toJSONString(result));
    }

}
