package fung.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseTest {

    @Test
    public void testHello() {
        System.out.println("Hello JDBC");
    }

    @Test
    public void testConnectMysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://172.28.17.26:3306/test", "root", "123456");
    }

}
