package fung.mybatis.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class BaseTest {

    @Test
    public void testHello() {
        System.out.println("Hello Mybatis");
    }

    @Test
    public void testSqlSessionFactory() throws IOException {
        Resource resource = new ClassPathResource("mybatis-config.xml", BaseTest.class);
        System.out.println(resource.getFile());
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource.getInputStream());
    }

}
