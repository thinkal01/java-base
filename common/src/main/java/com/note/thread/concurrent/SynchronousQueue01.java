package com.note.thread.concurrent;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueue01 {
    /**
     * 并发容器 - SynchronousQueue
     * 同步队列，是一个容量为 0 的队列。是一个特殊的 TransferQueue。
     * 必须有消费线程等待，才能使用的队列。
     * add 方法，无阻塞。若没有消费线程阻塞等待数据，则抛出异常。
     * put 方法，有阻塞。若没有消费线程阻塞等待数据，则阻塞。
     */
    @Test
    public void test() throws Exception {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " - " + queue.take());
            } catch (InterruptedException e) {
            }
        }, "output thread").start();

        TimeUnit.SECONDS.sleep(2);
        queue.put("put data");
        TimeUnit.SECONDS.sleep(5);
    }

}
