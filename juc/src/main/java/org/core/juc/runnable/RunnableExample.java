package org.core.juc.runnable;

import org.junit.jupiter.api.Test;

public class RunnableExample {

    /**
     * lambda方式创建runnable对象
     *
     * 笔记：对同一个Thread对象调用两次start方法会抛异常，必须创建不同的对象来起线程
     */
    @Test
    public void test1() {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread thread1 = new Thread(runnable);

        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

    /**
     * 匿名内部类方式创建线程
     */
    @Test
    public void test2() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }


    /**
     * 实现Runnable接口
     */
    @Test
    public void test3() {
        EchoThread echoThread = new EchoThread();
        Thread thread1 = new Thread(echoThread);
        Thread thread2 = new Thread(echoThread);

        thread1.start();
        thread2.start();
    }
}
