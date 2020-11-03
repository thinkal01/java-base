package com.note.leetcode.排序_数组;

import java.util.Arrays;

public class _38_某个数在数组中出现次数 {

    public int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;

        if (array.length == 1) return array[0] == k ? 1 : 0;

        int result = 0;
        int mid = array.length / 2;

        if (k < array[mid]) {
            result += getNumberOfK(Arrays.copyOfRange(array, 0, mid), k);
        } else if (k > array[mid]) {
            result += getNumberOfK(Arrays.copyOfRange(array, mid, array.length), k);
        } else {
            for (int i = mid; i < array.length; ++i) {
                if (array[i] == k) ++result;
                else break;
            }

            for (int i = mid - 1; i >= 0; --i) {
                if (array[i] == k) ++result;
                else break;
            }
        }

        return result;
    }
}
