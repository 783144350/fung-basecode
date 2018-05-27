package fung.slf4j.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    @Test
    public void testLogback() {
        Logger logger = LoggerFactory.getLogger(LogbackTest.class);
        logger.info("hello");
    }

}
