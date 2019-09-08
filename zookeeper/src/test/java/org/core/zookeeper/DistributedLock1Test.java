package org.core.zookeeper;

import org.junit.jupiter.api.Test;

public class DistributedLock1Test {

    @Test
    public void test() {
        int n = 500;
        Runnable runnable = new Runnable() {
            public void run() {
                DistributedLock1 lock = null;
                try {
                    lock = new DistributedLock1("127.0.0.1:2181", "lock");
                    lock.lock();
                    System.out.println(n);
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
