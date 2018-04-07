package fung.mybatis.test;

import com.alibaba.fastjson.JSON;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

import fung.mybatis.pojos.User;
import fung.mybatis.pojos.vo.StudentV;

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
        SqlSession session = factory.openSession();

        User user = new User().setName("fung").setAge(28).setCid(2014121709);
        session.insert("fung.mybatis.mapper.UserMpper.save", user);

        session.commit();

        session.close();
    }

    @Test
    public void testInsert() throws IOException {
        User user = new User().setName("fung").setAge(28).setCid(2014121709);

        SqlSession session = getSession();
        session.insert("fung.mybatis.mapper.UserMapper.save", user);
        session.commit();
        session.close();
    }

    @Test
    public void testSelectList() throws IOException {
        SqlSession session = getSession();
        List<User> userList = session.selectList("fung.mybatis.mapper.UserMapper.queryList");
        System.out.println(JSON.toJSONString(userList));
        session.commit();
        session.close();
    }

    @Test
    public void testMyCourse() throws IOException {
        SqlSession session = getSession();
        StudentV student = session.selectOne("fung.mybatis.mapper.vo.MyCourseMapper.queryStudentV", 1);
        System.out.println(JSON.toJSONString(student));
        session.commit();
        session.close();
    }

    private SqlSession getSession() throws IOException {
        Resource resource = new ClassPathResource("mybatis-config.xml", BaseTest.class);
        System.out.println(resource.getFile());
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource.getInputStream());
        return factory.openSession();
    }



}
