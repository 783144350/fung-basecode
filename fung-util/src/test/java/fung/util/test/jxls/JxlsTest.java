package fung.util.test.jxls;

import fung.util.jxls.Employee;
import org.junit.Before;
import org.junit.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class JxlsTest {

    private List<Employee> employees;

    @Before
    public void setUp() {
        employees = new ArrayList<>();
        employees.add(new Employee().setName("fung").setAge(28).setPayment(100.2D));
        employees.add(new Employee().setName("yan").setAge(26).setPayment(233.12D));
    }

    @Test
    public void testJxls() {
        Resource resourceTemplate = new ClassPathResource("object_collection_template.xls", JxlsTest.class);
        Resource resourceOutput = new ClassPathResource("object_collection_output.xlsx", JxlsTest.class);

        try (InputStream is = resourceTemplate.getInputStream()) {
            try (OutputStream os = new FileOutputStream(resourceOutput.getFile())) {
                Context context = new Context();
                context.putVar("employees", employees);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }q
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
