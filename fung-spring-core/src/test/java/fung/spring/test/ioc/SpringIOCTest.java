package fung.spring.test.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fung.spring.ioc.Person;

public class SpringIOCTest {

    @Test
    public void testSetInjection() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SetInjection-beans-config.xml", SpringIOCTest.class);
        Person person = ctx.getBean("chinese", Person.class);
        person.useAxe();
    }

    @Test
    public void testConstructorInjection() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ConstructorInjection-beans-config.xml", SpringIOCTest.class);
        Person person = ctx.getBean("chinese", Person.class);
        person.useAxe();
    }



}
