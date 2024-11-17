package org.core.juc.threadpool;

import java.util.concurrent.*;

public class CoreThreadPool {

    private int corePoolSize;

    private int maximumPoolSize;

    private BlockingQueue<Runnable> workQueue;

    private ThreadFactory threadFactory;

    private long keepAliveTime;

    private  RejectedExecutionHandler handler;

    public CoreThreadPool() {

    }

    public void s() {
        /**
         * alibaba规范不推荐使用Executors创建线程，提倡用其下调用的ThreadPoolExecutor去创建
         * TIP: ExecutorService executorService = Executors.newFixedThreadPool(10);
         */

        /**
         * corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
         *              Executors.defaultThreadFactory(), defaultHandler
         */
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor();
    }
}
