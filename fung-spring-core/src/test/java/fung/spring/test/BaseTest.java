package fung.spring.test;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BaseTest {

    @Test
    public void testHello() {
        System.out.println("Hello Spring Core");
    }

    @Test
    public void testResource() {
        Resource resource = new ClassPathResource("fung/spring/test/HelloSpringTest-beans-config.xml");
        System.out.println("资源存在吗？" + resource.exists());
    }

}
