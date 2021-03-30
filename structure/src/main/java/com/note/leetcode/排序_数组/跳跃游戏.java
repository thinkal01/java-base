package com.note.leetcode.排序_数组;

import org.junit.Test;

/**
 * 以最少的跳跃次数跳到最后一个数
 */
public class 跳跃游戏 {

    public int jump(int[] arr) {
        if (arr.length == 0) return 0;

        // 当前步数
        int step = 0;
        // 当前能到达的最远距离
        int cur = 0;
        // 多走一步能到达的最远距离
        int next = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (cur < i) {
                ++step;
                cur = next;
            }
            next = Math.max(next, cur + arr[i]);
        }

        return step;
    }

    @Test
    public void test() {
        int[] arr = {3, 2, 3, 1, 1, 4};
        System.out.println(jump(arr));
    }
}