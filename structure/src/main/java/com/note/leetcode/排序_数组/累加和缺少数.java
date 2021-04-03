package com.note.leetcode.排序_数组;

/**
 * 给定一个有序的正数数组arr和一个正数range，如果可以自由选择arr中的数字，想累加得到 1~range 范围上所有的数，返回arr最少还缺几个数。
 */
public class 累加和缺少数 {
    public static int minPatches(int[] arr, int n) {
        int result = 0;
        long range = 0;

        for (int num : arr) {
            while (num > range + 1) {
                ++result;
                // 当前不能凑成 range+1 则补上 range+1
                range += range + 1;
                if (range >= n) {
                    return result;
                }
            }

            // 使用数组元素,往前递推累加和
            range += num;
            if (range >= n) {
                return result;
            }
        }

        // 数组中元素用完后,依次补上 range+1
        while (range < n) {
            ++result;
            range += range + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 31, 33};
        int n = 2147483647;
        System.out.println(minPatches(test, n));
    }

}
