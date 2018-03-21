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
        LOGGER.info("status: {}", status);
        LOGGER.debug("debug");
    }

    @Test
    public void testRollingFile() {
        for(int i = 0; i < 500000; i++) {
            LOGGER.trace("trace");
            LOGGER.debug("debug");
            LOGGER.info("info");
            LOGGER.warn("warn");
            LOGGER.error("error");
        }
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
