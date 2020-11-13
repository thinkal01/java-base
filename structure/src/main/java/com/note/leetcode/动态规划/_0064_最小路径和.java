package com.note.leetcode.动态规划;

import org.junit.Test;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class _0064_最小路径和 {
    @Test
    public void test() {
        minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; ++i) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; ++j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }
}
