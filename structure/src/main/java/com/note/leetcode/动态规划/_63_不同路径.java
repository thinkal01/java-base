package com.note.leetcode.动态规划;

import org.junit.Test;

public class _63_不同路径 {
    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        int row = obstacleGrid.length, column = obstacleGrid[0].length;
        int[] dp = new int[column + 1];
        dp[1] = 1;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (obstacleGrid[i][j] == 1) dp[j + 1] = 0;
                else dp[j + 1] = dp[j] + dp[j + 1];
            }
        }

        return dp[column];
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[0][1] = 1;

        for (int i = 1; i <= obstacleGrid.length; ++i) {
            for (int j = 1; j <= obstacleGrid[0].length; ++j) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    continue;
                }

                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }

    /**
     * 考虑网格中有障碍物。从左上角到右下角将会有多少条不同的路径
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }
}
