package fung.log4j.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @Test
    public void testHello() {
        System.out.println("Hello Log4j");
    }

    @Test
    public void testLog() {
        int status = 0;
        LOGGER.error("status: {}", status);
    }

    @Test
    public void testPrintException() {
        try {
            LOGGER.info("test printing exception message");
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("error", e);
        }
    }

}
