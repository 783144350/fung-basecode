package fung.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentLogger implements Logger {

    @Override
    public void log(String msg) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ssS");
        System.out.println(format.format(new Date()) + " [" + Thread.currentThread().getName() + "]: " + msg);
    }
}
