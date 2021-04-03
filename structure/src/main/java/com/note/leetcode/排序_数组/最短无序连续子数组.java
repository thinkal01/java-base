package com.note.leetcode.排序_数组;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class 最短无序连续子数组 {
    /**
     * 思路: 升序数组, 左边最大数=< 当前位置元素 <=右边最小数
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 从右到左最小数
        int min = nums[nums.length - 1];
        // 当前数位置不对的最小下标
        int noMinIndex = -1;
        for (int i = nums.length - 2; i != -1; i--) {
            // 当前大于右边最小
            if (nums[i] > min) {
                noMinIndex = i;
            } else {
                min = nums[i];
            }
        }

        // 未找到,说明数组有序
        if (noMinIndex == -1) {
            return 0;
        }

        // 从左到右最大数
        int max = nums[0];
        // 当前数位置不对的最大下标
        int noMaxIndex = -1;
        for (int i = 1; i != nums.length; i++) {
            // 当前小于左边最大
            if (nums[i] < max) {
                noMaxIndex = i;
            } else {
                max = nums[i];
            }
        }

        return noMaxIndex - noMinIndex + 1;
    }

    @Test
    public void main() {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println(findUnsortedSubarray(arr));
    }
}
