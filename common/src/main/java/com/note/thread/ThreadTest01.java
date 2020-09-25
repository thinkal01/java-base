package com.note.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest01 {
    public void test01() {
        try {
            // 休眠1秒
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
    }

    @Test
    public void test02() {
        threadTest();
        Runtime.getRuntime().gc();

        try {
            // 函数内子线程会继续执行
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    public void threadTest() {
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.out.println("abc");
                }
            } catch (InterruptedException e) {
            }
        }).start();
    }

    @Test
    public void test03() throws InterruptedException {
        threadTest2();
        threadTest2();
        threadTest2();

        while (true) {
            System.out.println("activeCount:" + Thread.activeCount());
            Thread.sleep(1000);
        }
    }


    public void threadTest2() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ":abc");
        });
        // 不加下面这句,线程不会销毁
        executorService.shutdown();
    }
}
