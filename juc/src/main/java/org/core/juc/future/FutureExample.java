package org.core.juc.future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class FutureExample {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
        /**
         * 这里submit方法重载了3个方法，可以看源码，其实三个方法是一模一样的
         * 全部都把runnable和callable通过FutureTask转成了runnableFuture(实际上就是runnable)
         * 最终都是把runnable送到线程池里面执行，返回结果封装到future中(如果有返回值)
         *
         * 源码分析：
         * 关于FutureTask:
         * FutureTask实现了RunnableFuture接口
         *                  -RunnableFuture继承了Runnable, Future两个接口
         * 1. new FutureTask的时候，构造方法可以传callable或者runnable, 不管什么类型，构造里面都将其转为callable放到成员变量中
         * 2. futureTask本身就是一个runnable接口子类，在run方法中调用步骤1的callable变量的call方法，完成方法调用
         * 3. call()的返回值放到futureTask的outcome成员变量中
         * 4. futureTask同时也是future接口子类，有get()方法获取返回值
         *
         * 可以看出，其实callable底层调用的还是runnable, 不过对其进行了扩展
         */
        Future<String> future = threadExecutor.submit(() -> {
            TimeUnit.SECONDS.sleep(10);
            return "HI ARE YOU OKAY";
        });

        System.out.println(future.get());
    }

    /**
     * test2 test3都是为了测试用的实际使用，还是推荐使用线程池
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            TimeUnit.SECONDS.sleep(10);
            return "HI ARE YOU OKAY";
        };

        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Are You Okay");
        };
        FutureTask futureTask = new FutureTask(runnable, null);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void test4() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "Are You Okay";
        });
        threadPool.submit(futureTask);
        System.out.println(futureTask.get());
    }

    @Test
    public void test5() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "Are You Okay";
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
