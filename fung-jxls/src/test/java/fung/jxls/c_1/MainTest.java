package fung.jxls.c_1;

import fung.jxls.BaseTest;
import fung.jxls.utils.JxlsUtils;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainTest extends BaseTest {

    @Test
    public void test() {

        Map<String, Object> model = new HashMap<>();
        model.put("id", "001");
        model.put("name", "张三");
        model.put("age", 18);

        exportExcel(model, MainTest.class);

    }

}
