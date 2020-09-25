package com.note.leetcode.动态规划;

import org.junit.Test;

public class _188_股票4 {
    @Test
    public void test() {
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     * 最多可以完成 k 笔交易
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        if (k >= n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j++) {
                /**
                 * 不做处理,dp[i][j−1]
                 * 卖出股票，设是在第m天买入,prices[j]−prices[m]+dp[i−1][m],where m=0,1...j−1
                 */
                maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
            }
        }

        return dp[k][n - 1];
    }
}