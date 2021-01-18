package com.note.thread.aqs;

import lombok.Data;
import org.junit.Test;

import java.util.concurrent.atomic.*;

public class AtomicTest {
    private AtomicInteger value = new AtomicInteger(0);
    private int[] s = {2, 1, 4, 6};

    AtomicIntegerArray a = new AtomicIntegerArray(s);
    AtomicReference<User> user = new AtomicReference<>();
    AtomicIntegerFieldUpdater<User> old = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public int getNext() {
        User user = new User();
        System.out.println(old.getAndIncrement(user));
        System.out.println(old.getAndIncrement(user));
        System.out.println(old.getAndIncrement(user));

        a.getAndIncrement(2);
        a.getAndAdd(2, 10);
        return value.getAndIncrement();
    }

    @Data
    public class User {
        private String name;
        public volatile int old;
    }

    @Test
    public void test() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        // 成功返回true
        boolean b = atomicBoolean.compareAndSet(false, true);
        System.out.println(b);
    }

}
