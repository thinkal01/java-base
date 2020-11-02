package com.note.thread;

import org.junit.Test;

public class Volatile01 {
    public volatile int inc = 0;

    /**
     * 自增操作不具备原子性，它包括读取变量的原始值、加1操作、写入工作内存。
     * 线程1对变量进行自增操作，线程1先读取了变量inc的原始值，然后线程1被阻塞了；
     * 线程2对变量进行自增操作，线程2也去读取变量inc的原始值，由于线程1只是对变量inc进行读取操作，而没有对变量进行修改操作，
     * 所以不会导致线程2的工作内存中缓存变量inc的缓存行无效，所以线程2会直接去主存读取inc的值，发现inc的值时10，进行加1操作，
     * 然后线程1接着进行加1操作，inc的值为11，然后将11写入工作内存，最后写入主存。
     * 线程2把11写入工作内存，最后写入主存。那么两个线程分别进行了一次自增操作后，inc只增加了1。
     *
     * 线程1对变量进行读取操作之后，被阻塞了，并没有对inc值进行修改。
     * 虽然volatile能保证线程2对变量inc的值读取是从内存中读取的，但是线程1没有进行修改，所以线程2不会看到修改的值。
     */
    @Test
    // todo run会一直执行,不输出结果,test可以
    public void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 采用synchronized,Lock,AtomicInteger可以达到效果
                for (int j = 0; j < 1000; j++) inc++;
            }).start();
        }

        // 保证前面的线程都执行完
        while (Thread.activeCount() > 1) Thread.yield();
        // <=10000
        System.out.println(inc);
    }
}