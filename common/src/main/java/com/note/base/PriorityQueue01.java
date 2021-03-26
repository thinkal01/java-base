package com.note.base;

import org.junit.Test;

import java.util.PriorityQueue;

public class PriorityQueue01 {
    @Test
    public void test01() {
        // a-b 从小到大,相等的往后排
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        pq.offer(new int[]{1, 0});
        pq.offer(new int[]{2, 1});
        pq.offer(new int[]{3, 2});
        pq.offer(new int[]{1, 2});
        System.out.println(pq.poll()[1]);
        System.out.println(pq.poll()[1]);
        System.out.println(pq.poll()[1]);
        System.out.println(pq.poll()[1]);
        // null
        System.out.println(pq.poll());
    }
}
