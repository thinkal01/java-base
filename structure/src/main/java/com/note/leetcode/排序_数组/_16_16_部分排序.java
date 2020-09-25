package com.note.leetcode.排序_数组;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 */
public class _16_16_部分排序 {
    @Test
    public void test() {
        int[] sort = subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        System.out.println(sort[0]);
        System.out.println(sort[1]);
    }

    /*
     * { 1, 5, 4, 3, 2, 6, 7 }
     */
    public int[] subSort(int[] nums) {
        if (nums.length == 0) return new int[]{-1, -1};

        // 从左扫描到右寻找逆序对（正序：逐渐变大）
        int max = nums[0];
        // 用来记录最右的那个逆序对位置
        int r = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                r = i;
            }
        }

        // 提前结束
        if (r == -1) return new int[]{-1, -1};

        // 从右扫描到左寻找逆序对（正序：逐渐变小）
        int min = nums[nums.length - 1];
        // 用来记录最左的那个逆序对位置
        int l = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                l = i;
            }
        }

        return new int[]{l, r};
    }
}
