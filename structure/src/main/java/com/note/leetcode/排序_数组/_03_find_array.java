package com.note.leetcode.排序_数组;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 判断数组中是否含有该整数。
 */
public class _03_find_array {

    /**
     * 从右上角或左下角开始找，逐行排除，或者用二分法查找
     */
    public static boolean find(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        int row = 0;
        int column = array[0].length - 1;

        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            } else if (array[row][column] > target) {
                --column;
            } else {
                ++row;
            }
        }

        return false;
    }

    public static boolean find2(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        int left = 0;
        int right = array.length * array[0].length - 1;
        int col = array[0].length;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = array[mid / col][mid % col];

            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}