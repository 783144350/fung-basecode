package fung.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fung.spring.HelloSpring;

public class HelloSpringTest {

    @Test
    public void testBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("HelloSpringTest-beans-config.xml", HelloSpringTest.class);
        HelloSpring bean = ctx.getBean("hello", HelloSpring.class);
        bean.hello();
    }

}
