package fung.jxls;

import fung.jxls.utils.JxlsUtils;

import java.io.*;
import java.util.Map;

public class BaseTest {

    private static final String NAME_TEMPLATE = "template.xlsx";
    private static final String NAME_OUTPUT = "output.xlsx";

    public void exportExcel(Map<String, Object> model, Class clazz) {
        try (InputStream is = clazz.getResourceAsStream(NAME_TEMPLATE)) {
            try (OutputStream os = new FileOutputStream(new File(clazz.getResource("").getPath() + NAME_OUTPUT))) {
                JxlsUtils.exportExcel(is, os, model);
                System.out.println("完成");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
