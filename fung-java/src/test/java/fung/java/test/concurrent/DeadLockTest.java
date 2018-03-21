package fung.java.test.concurrent;

import org.junit.Test;

public class DeadLockTest {

    private Object a = new Object();
    private Object b = new Object();

    @Test
    public void testDeadLock() {
        new Thread(() -> {
           System.out.println("h");
        }).start();
    }

}
