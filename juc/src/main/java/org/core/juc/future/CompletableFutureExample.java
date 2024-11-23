package org.core.juc.future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * CompletableFuture对比于Future最大的优势是有回调函数，程序可以继续运行，不会在get方法阻塞住
 */
public class CompletableFutureExample {

    /**
     * supplyAsync可以获取返回值
     *
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

    /**
     * runAsync无返回值
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
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
        System.out.println(future.get());
        ;
    }

    @Test
    public void test3() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            int random = ThreadLocalRandom.current().nextInt(10);
            System.out.println("进入第一阶段线程,结果值:" + random);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return random;
        }, threadPool).whenComplete((result, ex) -> {
            System.out.println("第二阶段获取到第一阶段结果值:" + result);
        }).exceptionally(throwable -> {
            System.out.println("程序异常");
            return null;
        });

        //因为这里是JUNIT，如果不阻塞主线程，junit会认为已经执行完毕，整体退出了，如果用main方法并且提供自定义的线程池就不会退出。
        //CompletableFuture默认的线程池是守护线程。主线程退出，就会自动退出。
        TimeUnit.SECONDS.sleep(100);
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            int random = ThreadLocalRandom.current().nextInt(10);
            System.out.println("进入第一阶段线程,结果值:" + random);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return random;
        }, threadPool).whenComplete((result, ex) -> {
            System.out.println("第二阶段获取到第一阶段结果值:" + result);
        }).exceptionally(throwable -> {
            System.out.println("程序异常");
            return null;
        });
    }
}
