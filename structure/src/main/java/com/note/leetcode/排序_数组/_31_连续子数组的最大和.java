package com.note.leetcode.排序_数组;

import org.junit.Test;

/**
 * 数组中有正数也有负数，数组中一个或连续的多个整数组成一个子数组，求连续子数组的最大和
 */
public class _31_连续子数组的最大和 {

    /**
     * 若和小于 0，则将最大和置为当前值，否则计算最大和。
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
