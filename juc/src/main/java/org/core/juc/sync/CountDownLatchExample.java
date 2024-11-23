package org.core.juc.sync;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                latch.countDown();
            }).start();
        }
        System.out.println("开始时间:"+System.currentTimeMillis());
        latch.await();
        System.out.println("结束时间:"+System.currentTimeMillis());
    }
}
