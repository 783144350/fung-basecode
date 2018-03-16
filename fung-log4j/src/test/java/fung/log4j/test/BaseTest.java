package fung.log4j.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    @Test
    public void testHello() {
        System.out.println("Hello Log4j");
    }

    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger(BaseTest.class);
        int status = 0;
        logger.info("status: {}", status);
    }

}
