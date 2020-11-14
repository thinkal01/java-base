package com.note.leetcode.排序_数组;

import org.junit.Test;

public class _0055_跳跃游戏 {
    @Test
    public void test() {
        canJump(new int[]{3, 2, 1, 0, 4});
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;

        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }

}
