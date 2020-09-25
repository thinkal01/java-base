package com.note.leetcode.动态规划;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 尽可能地完成更多的交易
 */
public class _122_股票2 {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 贪心算法
     */
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }

        return profit;
    }

    /**
     * 动态规划
     */
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金=卖,或者不操作
        // 1：持有股票=买,或者不操作
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        // 并且规定在买入股票的时候，扣除手续费
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        return dp[len - 1][0];
    }

}
