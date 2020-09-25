package com.note.Queue;

import org.junit.Test;

public class MyPriorityQueueTest {
    @Test
    public void test() {
        // PriorityQueue priorityQueue = new PriorityQueue();
        // PriorityBlockingQueue queue = new PriorityBlockingQueue(100);

        MyPriorityQueue pq = new MyPriorityQueue(10);
        pq.insert(30);
        pq.insert(45);
        pq.insert(15);
        pq.insert(2);
        pq.insert(1);

        while (!pq.isEmpty()) {
            long value = pq.remove();
            System.out.print(value + " ");
        }
    }
}
