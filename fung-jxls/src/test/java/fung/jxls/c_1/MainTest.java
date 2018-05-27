package fung.jxls.c_1;

import fung.jxls.utils.JxlsUtils;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainTest {

    private static final String NAME_TEMPLATE = "template.xlsx";
    private static final String NAME_OUTPUT = "output.xlsx";

    @Test
    public void test() {
        try (InputStream is = MainTest.class.getResourceAsStream(NAME_TEMPLATE)) {
            try (OutputStream os = new FileOutputStream(new File(MainTest.class.getResource("").getPath() + NAME_OUTPUT))) {

                Map<String, Object> model = new HashMap<>();
                model.put("id", "001");
                model.put("name", "张三");
                model.put("age", 18);

                JxlsUtils.exportExcel(is, os, model);
                System.out.println("完成");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
