package org.core.current.future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture对比于Future最大的优势是有回调函数，程序可以继续运行，不会在get方法阻塞住
 */
public class CompletableFutureExample {

    /**
     * supplyAsync可以获取返回值
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "HI ARE YOU OKAY";
        });

        System.out.println(future.get());
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10L);
                System.out.println("线程执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("方法调用完成");
        future.get();
    }
}
