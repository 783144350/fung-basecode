package fung.spring.core.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import fung.spring.HelloSpring;

public class BaseTest {

    @Test
    public void testHello() {
        System.out.println("Hello Spring Core");
    }

    @Test
    public void testResource() {
        Resource resource = new ClassPathResource("beans-config.xml");
        System.out.println("资源存在吗？" + resource.exists());
    }

    @Test
    public void testBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        HelloSpring bean = ctx.getBean("hello", HelloSpring.class);
        bean.hello();
    }

}
