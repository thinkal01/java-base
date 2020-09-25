package com.note.thread.aqs;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

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

}
