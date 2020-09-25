package com.note.thread.threadPool;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutor01 {
    /**
     * 等待任务结束
     */
    @Test
    public void test01() throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5,
                10,
                1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < 10000; i++) {
            threadPool.execute(() -> {
                // System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                    count.getAndIncrement();
                } catch (InterruptedException e) {
                }
            });
        }

        System.out.println("count.get() = " + count.get());

        // 等待任务完成
        /*while (threadPool.getActiveCount() > 0) {
            Thread.sleep(100);
        }*/

        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
            System.out.println("active threads = " + Thread.activeCount());
            Thread.sleep(100);
        }

        System.out.println("count.get() = " + count.get());
        System.out.println("active threads = " + Thread.activeCount());
    }

    public void main1() {
        // 10个线程来处理大量的任务
        // ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        // ExecutorService pool = Executors.newWorkStealingPool();

        while (true) {
            Future f = pool.submit(() -> {
            });

            pool.schedule(() -> System.out.println(Thread.currentThread().getName()), 5, TimeUnit.SECONDS);
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            });
        }
    }
}



