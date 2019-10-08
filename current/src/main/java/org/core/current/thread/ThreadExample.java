package org.core.current.thread;

import org.junit.jupiter.api.Test;

public class ThreadExample {

    /**
     * 继承Thread类，重写run方法
     */
    @Test
    public void test1() {
        EchoThread echoThread1 = new EchoThread();
        EchoThread echoThread2 = new EchoThread();

        echoThread1.start();
        echoThread2.start();
    }

}
