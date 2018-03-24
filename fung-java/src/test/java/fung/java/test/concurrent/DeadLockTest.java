package fung.java.test.concurrent;

import fung.java.util.ConcurrentLogger;
import fung.java.util.Logger;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DeadLockTest {

    private final Object a = new Object();
    private final Object b = new Object();

    private Logger logger = new ConcurrentLogger();

    @Test
    public void testDeadLock() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            logger.log("Task A started");
            logger.log("Request for monitor a");
            synchronized (a) {
                logger.log("Get monitor a");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.log("Request for monitor b");
                synchronized (b) {
                    logger.log("Get monitor b");
                }
            }
            latch.countDown();
            logger.log("Task A finished");
        }, "Task-A").start();

        new Thread(() -> {
            logger.log("Task B started");
            logger.log("Request for monitor b");
            synchronized (b) {
                logger.log("Get monitor b");
                logger.log("Request for monitor a");
                synchronized (a) {
                    logger.log("Get monitor a");
                }
            }
            latch.countDown();
            logger.log("Task B finished");
        }, "Task-B").start();

        latch.await();

    }


}
