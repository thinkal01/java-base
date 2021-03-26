package com.note.thread.aqs;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {

    @Test
    public void test() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        // 成功返回true
        boolean b = atomicBoolean.compareAndSet(true, false);
        System.out.println(b);
    }

    @Test
    public void test2() {
        int[] s = {2, 1, 4, 6};
        System.out.println(Arrays.toString(s));
        AtomicIntegerArray array = new AtomicIntegerArray(s);
        array.getAndIncrement(2);
        System.out.println(array);
        array.getAndAdd(1, 10);
        System.out.println(array);
    }

    /**
     * AtomicReference类提供了一个可以原子读写的对象引用变量。
     * 比较的是两个对象的地址是否相等。可以保证修改对象引用时的线程安全性。
     * 原子意味着尝试更改相同AtomicReference的多个线程（例如，使用比较和交换操作）不会使AtomicReference最终达到不一致的状态。
     * AtomicReference甚至有一个先进的compareAndSet方法，它可以将引用与预期值（引用）进行比较，如果它们相等，则在AtomicReference对象内设置一个新的引用。
     */
    @Test
    public void test3() {
        String initialReference = "initial value referenced";
        AtomicReference<String> atomicStringReference = new AtomicReference<>(initialReference);

        String newReference = "new value referenced";
        // 多线程修改,这里可以判断当前线程是否修改成功
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }

    @Test
    public void test4() {
        AtomicIntegerFieldUpdater<User> old = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");
        User user = new User();
        old.getAndIncrement(user);
        System.out.println(user.getOld());
    }

    @Data
    public class User {
        private String name;
        public volatile int old;
    }

}
