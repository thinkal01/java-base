package com.note.leetcode.排序_数组;

/**
 * 数组中有正数也有负数，数组中一个或连续的多个整数组成一个子数组，求连续子数组的最大和
 */
public class _31_连续子数组的最大和 {

    /**
     * 若和小于 0，则将最大和置为当前值，否则计算最大和。
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int result = nums[0];
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            result = Math.max(sum, result);
        }

        return result;
    }
}
