package com.note.leetcode.排序_数组;

public class _29_数组中出现次数超过一半的数字 {

    public int moreThanHalfNum(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        int times = 0;
        for (int i : nums) {
            if (i == candidate) ++times;
        }

        return times * 2 >= nums.length ? candidate : 0;
    }
}
