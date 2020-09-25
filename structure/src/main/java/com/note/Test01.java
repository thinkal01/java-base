package com.note;

import org.junit.Test;

public class Test01 {
    @Test
    public void test() {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        int capacity = 10;
        System.out.println(maxValueExactly(values, weights, capacity));

    }

    public int maxValueExactly(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (capacity <= 0) return 0;
        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 1; i <= values.length; ++i) {
            for (int j = weights[i - 1]; j <= capacity; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
            }
        }

        return dp[values.length][capacity];
    }

}
