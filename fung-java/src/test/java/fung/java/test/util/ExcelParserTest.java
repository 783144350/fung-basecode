package fung.java.test.util;

import com.alibaba.fastjson.JSON;
import com.skyworthdigital.excel.ExcelParseException;
import com.skyworthdigital.excel.ExcelParser;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;


public class ExcelParserTest {

    @Test
    public void testExcelParser() throws IOException, ExcelParseException {
        Resource resource = new ClassPathResource("test.xls", ExcelParserTest.class);

        List<Model> result = new ExcelParser().parse(resource.getFilename(),
                resource.getInputStream(), Model.class);

        System.out.println("解析结果：" + JSON.toJSONString(result));
    }

}
