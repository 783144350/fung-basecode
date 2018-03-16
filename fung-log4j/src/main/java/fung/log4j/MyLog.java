package fung.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLog {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MyLog.class);
        logger.info("hello log");
    }
}
