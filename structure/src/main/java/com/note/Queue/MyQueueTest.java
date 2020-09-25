package com.note.Queue;

import org.junit.Test;

public class MyQueueTest {
    @Test
    public void test() {
        MyQueue mq = new MyQueue(5);
        mq.insert(30);
        mq.insert(20);
        mq.insert(10);
        mq.insert(2);
        mq.insert(1);
        mq.insert(20);

        while (!mq.isEmpty()) {
            System.out.println(mq.remove());
        }
    }

}
