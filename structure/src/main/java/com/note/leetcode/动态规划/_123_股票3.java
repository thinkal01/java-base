package com.note.leetcode.动态规划;

import org.junit.Test;

public class _123_股票3 {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     * 最多可以完成 两笔 交易
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] dp0 = new int[prices.length];
        int[] dp1 = new int[prices.length];

        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            dp0[i] = Math.max(dp0[i - 1], prices[i] - min);
        }

        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; --i) {
            max = Math.max(max, prices[i]);
            dp1[i] = Math.max(dp1[i + 1], max - prices[i]);
        }

        max = dp0[dp0.length - 1];
        for (int i = 0; i < dp0.length - 1; ++i) {
            max = Math.max(max, dp0[i] + dp1[i + 1]);
        }

        return max;
    }
}