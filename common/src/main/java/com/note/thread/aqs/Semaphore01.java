package com.note.thread.aqs;

import org.junit.Test;

import java.util.concurrent.*;

public class Semaphore01 {

    public void test01() {
        // 同时只有10个线程可以执行
        Semaphore semaphore = new Semaphore(10);
        while (true) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " is threadTest ...");
                    Thread.sleep(2000);
                    semaphore.release();
                } catch (InterruptedException e) {
                }
            }).start();
        }
    }

    /**
     * 将程序改造成有10个线程来消费产生的数据
     * 每个消费者都需要一秒才能处理完，程序应保证这些消费者线程依次有序地消费数据，
     * 只有上一个消费者消费完后，下一个消费者才能消费数据，下一个消费者是谁都可以，但要保证这些消费者线程拿到的数据是有顺序的。
     */
    @Test
    public void test02() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);
        // SynchronousQueue是一个不存储元素的BlockingQueue。
        // 每一个put操作必须要等待一个take操作，否则不能继续添加元素，反之亦然
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    String input = queue.take();
                    Thread.sleep(1000);
                    String output = input + "-" + (System.currentTimeMillis() / 1000);
                    System.out.println(Thread.currentThread().getName() + ":" + output);
                    semaphore.release();
                } catch (InterruptedException e) {
                }
            }).start();
        }

        System.out.println("begin:" + (System.currentTimeMillis() / 1000));

        for (int i = 0; i < 10; i++) {
            queue.put(i + "");
            System.out.println("put " + i);
        }

        TimeUnit.SECONDS.sleep(2);
    }

    public void test03() {
        ExecutorService service = Executors.newCachedThreadPool();
        // 允许同时访问的线程个数
        Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    sp.acquire();
                } catch (InterruptedException e1) {
                }
                System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException e) {
                }
                System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
                // 释放
                sp.release();
                //下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
                System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
            };
            service.execute(runnable);
        }
    }
}
