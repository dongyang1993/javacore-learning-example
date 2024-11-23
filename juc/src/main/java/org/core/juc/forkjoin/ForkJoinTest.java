package org.core.juc.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class ForkJoinTest {

/*    @Test
    public void test1() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Runnable runnable = () -> {
            try {
                System.out.println("等待30秒");
                TimeUnit.SECONDS.sleep(30);
            }catch (Exception e) {
                e.printStackTrace();
            }
            RecursiveTask<Integer> task = new RecursiveTask<>() {
                @Override
                protected Integer compute() {
                    System.out.println("等待30秒");
                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return 0;
                }
            };
            Integer invoke = forkJoinPool.invoke(task);
            System.out.println(invoke);
        };
    }*/
}
