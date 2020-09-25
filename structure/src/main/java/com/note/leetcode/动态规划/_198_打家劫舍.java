package com.note.leetcode.动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 不触动警报装置的情况下，一夜之内能够偷窃到的最高金额
 */
public class _198_打家劫舍 {

    @Test
    public void test() {
        System.out.println(rob2(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[length - 1];
    }

    /**
     * 所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        /**
         * 计算两次
         */
        return Math.max(
                rob(Arrays.copyOf(nums, nums.length - 1)),
                rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

}
