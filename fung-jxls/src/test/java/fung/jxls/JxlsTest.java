package fung.jxls;

import org.junit.Before;
import org.junit.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JxlsTest {

    private List<Employee> employees;

    @Before
    public void setUp() {
        employees = new ArrayList<>();
        employees.add(new Employee().setName("fung").setAge(28).setPayment(100.2D));
        employees.add(new Employee().setName("yan").setAge(26).setPayment(233.12D));
    }

    @Test
    public void testPath() {
        System.out.println(JxlsTest.class.getResource(""));
        System.out.println(JxlsTest.class.getResource("/"));

        System.out.println(JxlsTest.class.getClassLoader().getResource(""));
        System.out.println(JxlsTest.class.getClassLoader().getResource("/"));

        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(ClassLoader.getSystemResource("/"));

        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void testJxls() {
        try (InputStream is = JxlsTest.class.getResourceAsStream("test.xlsx")) {
            try (OutputStream os = new FileOutputStream(new File(JxlsTest.class.getResource("/").getPath() + "out.xlsx"))) {
                Context context = new Context();
                context.putVar("employees", employees);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
