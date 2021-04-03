package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.Arrays;

public class 最小不可组成和 {

    /**
     * arr=[3,2,5]。子集{2}相加产生 2 为 min，子集{3,2,5}相加产生 10 为 max。在区间[2,10] 上，4、 6 和 9 不能被任何子集相加得到，其中 4 是 arr 的最小不可组成和。
     * arr=[1,2,4]。子集{1}相加产生 1 为 min，子集{1,2,4}相加产生 7 为 max。在区间[1,7]上， 任何数都可以被子集相加得到，所以 8 是 arr 的最小不可组成和。
     */
    public int unformedSum(int[] arr) {
        // 数组和
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // 数组前i项是否能组成和j
        boolean[][] dp = new boolean[arr.length][sum + 1];
        dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (dp[i - 1][j]) { // 不选择arr[i]
                    dp[i][j] = true;
                } else if (j - arr[i] >= 0) { // 选择arr[i]
                    dp[i][j] = dp[i - 1][j - arr[i]];
                }
            }
        }

        for (int i = 1; i <= sum; ++i) {
            if (!dp[arr.length - 1][i]) {
                return i;
            }
        }

        return sum + 1;
    }

    /**
     * 采用一维数组
     */
    public static int unformedSum2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 0; i != arr.length; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] |= dp[j - arr[i]];
            }
        }

        for (int i = min; i != dp.length; i++) {
            if (!dp[i]) {
                return i;
            }
        }

        return sum + 1;
    }

    /**
     * 数组中有 1 这个数
     * 思路: 从0开始递推
     */
    public static int unformedSum3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Arrays.sort(arr);
        int range = 0;

        for (int i = 0; i != arr.length; i++) {
            if (arr[i] > range + 1) {
                // 说明 range+1 这个数不能凑成
                return range + 1;
            } else {
                // range之前所有数都能凑成,range+arr[i]之前的所有数也能凑成
                range += arr[i];
            }
        }

        return range + 1;
    }

    public static int[] generateArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue) + 1;
        }
        return res;
    }

    @Test
    public void main() {
        int len = 27;
        int max = 30;
        int[] arr = generateArray(len, max);
        long start = System.currentTimeMillis();
        System.out.println(unformedSum(arr));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + " ms");
        System.out.println("======================================");

        start = System.currentTimeMillis();
        System.out.println(unformedSum(arr));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + " ms");
        System.out.println("======================================");

        System.out.println("set arr[0] to 1");
        arr[0] = 1;
        start = System.currentTimeMillis();
        System.out.println(unformedSum(arr));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + " ms");
    }

}
