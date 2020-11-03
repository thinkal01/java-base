package com.note.leetcode.排序_数组;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1。 NOTE：
 * 给出的所有元素都大于 0，若数组大小为 0，请返回-1。假设数组中不存在重复元素。
 */
public class _07_reverse_list {

    @Test
    public void test() {
        System.out.println(minInReversingList(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minInReversingList(new int[]{1, 2, 3, 4, 5, 6}));
        // System.out.println(minInReversingList(new int[]{1}));
        // System.out.println(minInReversingList(new int[]{2, 2, 2, 2, 1, 2}));
        // System.out.println(minInReversingList(new int[]{2, 1, 2, 2, 2, 2}));
        // System.out.println(minInReversingList(new int[]{6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6}));
    }

    /**
     * 利用二分法，找到数组的中间元素 mid
     */
    public static int minInReversingList(int[] array) {
        if (array == null || array.length == 0) return -1;

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[mid - 1] > array[mid]) {
                return array[mid];
            }

            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
