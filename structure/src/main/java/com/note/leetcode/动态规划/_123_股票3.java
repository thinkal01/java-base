package com.note.leetcode.动态规划;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 最多可以完成 两笔 交易
 * 同一天既可以买也可以卖
 */
public class _123_股票3 {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        int minPrice = prices[0];
        for (int i = 1; i < n; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }

        int maxPrice = prices[n - 1];
        int max = 0;
        for (int i = n - 2; i >= 0; --i) {
            maxPrice = Math.max(maxPrice, prices[i]);
            max = Math.max(max, maxPrice - prices[i] + dp[i]);
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
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

    public static void main(String[] args) {
        Integer b = Integer.valueOf(1);
        Integer a = Integer.parseInt("1");
        System.out.println(a == b);
    }
}