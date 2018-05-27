package fung.jxls.c_3;

import fung.jxls.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        School school = new School().setName("安陆一中")
                .addClazz(new Clazz().setName("高三五班")
                        .addStudent(new Student().setId("0001").setName("Fung").setAge(28))
                        .addStudent(new Student().setId("0002").setName("Yuan").setAge(26)))
                .addClazz(new Clazz().setName("高二一班")
                        .addStudent(new Student().setId("0003").setName("Yan").setAge(25))
                        .addStudent(new Student().setId("0004").setName("Xing").setAge(27))
                        .addStudent(new Student().setId("0005").setName("Yi").setAge(27)));

        Map<String, Object> model = new HashMap<>();
        model.put("school", school);

        exportExcel(model, MainTest.class);
    }

}
