package fung.jxls.c_2;

import fung.jxls.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person().setId("001").setName("方圆").setAge(28));
        persons.add(new Person().setId("002").setName("严辛夷").setAge(26));

        Map<String, Object> model = new HashMap<>();
        model.put("persons", persons);

        exportExcel(model, MainTest.class);
    }

}
