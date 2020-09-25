package com.note.dynamicProgram;

public class Knapsack {
    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 5, 6, 4};
        int capacity = 10;
        System.out.println(maxValue(values, weights, capacity));
        System.out.println(maxValue1(values, weights, capacity));
    }

    /**
     * @return 如果返回-1，代表没法刚好凑到capacity这个容量
     */
    static int maxValueExactly(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];

        // 初始化为一个负数最大值
        for (int j = 1; j <= capacity; j++) {
            dp[j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }

        return dp[capacity] < 0 ? -1 : dp[capacity];
    }

    /**
     * 一维数组优化
     * @param values
     * @param weights
     * @param capacity
     * @return
     */
    static int maxValue(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            // j >= weights[i - 1]
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }

        return dp[capacity];
    }

    /**
     * 二维数组实现
     * @param values
     * @param weights
     * @param capacity
     * @return
     */
    static int maxValue1(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;
        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = weights[i - 1]; j <= capacity; j++) {
                dp[i][j] = Math.max(
                        dp[i - 1][j],
                        values[i - 1] + dp[i - 1][j - weights[i - 1]]);
            }
        }

        return dp[values.length][capacity];
    }
}
