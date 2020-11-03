package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * 调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 */
public class _14_order_array {

    @Test
    public void test() {
        int[] ints = reOrderArray(new int[]{8, 5, 4, 2, 3, 6, 5, 2, 9, 7, 8, 1, 2, 3});
        System.out.println(Arrays.toString(ints));
        return;
    }

    /**
     * 使用双指针法
     */
    public int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0) return null;

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                ++left;
            }
            while (left < right && array[right] % 2 == 0) {
                --right;
            }

            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }

        return array;
    }
}
