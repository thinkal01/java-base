package com.note.leetcode.动态规划;

import org.junit.Test;

public class _674_连续递增序列 {
    @Test
    public void test() {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int temp = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                max = Math.max(max, ++temp);
            } else {
                temp = 1;
            }
        }

        return max;
    }

}
