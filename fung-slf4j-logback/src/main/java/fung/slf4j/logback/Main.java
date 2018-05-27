package fung.slf4j.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello logback");

        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("hello logback");

    }
}
