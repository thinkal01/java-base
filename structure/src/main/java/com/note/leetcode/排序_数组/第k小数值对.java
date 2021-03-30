package com.note.leetcode.排序_数组;

import java.util.Arrays;

public class 第k小数值对 {
    /**
     * arr[i] 和 arr[0] 到 arr[n-1] 组成数值对,求第k个数值对
     */
    public int[] kthMinPair(int[] arr, int k) {
        int n = arr.length;
        if (k > n * n) {
            return new int[0];
        }

        Arrays.sort(arr);
        // 数组从0开始,所以-1
        int firstNum = arr[(k - 1) / n];
        // 比 firstNum 小的数的数量
        int lessFirstNumSize = 0;
        // 等于 firstNum 的数的数量
        int firstNumSize = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] < firstNum) {
                ++lessFirstNumSize;
            } else if (arr[i] == firstNum) {
                ++firstNumSize;
            } else {
                break;
            }
        }

        return new int[]{firstNum, arr[(k - lessFirstNumSize * n - 1) / firstNumSize]};
    }
}
