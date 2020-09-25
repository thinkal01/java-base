package com.note.leetcode.动态规划;

import org.junit.Test;

import java.util.Arrays;

public class _673_最长递增子序列个数 {
    @Test
    public void test() {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    /**
     * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
     */
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        // 以i结尾最大长度
        int[] lengths = new int[N];
        // 以i结尾最大子序列个数
        int[] counts = new int[N];
        Arrays.fill(counts, 1);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j)
                if (nums[j] < nums[i]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        // 还原counts[i]值
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
        }

        int longest = 0, ans = 0;
        // 找出最大长度
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }

        // 计算最大子序列个数
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }

        return ans;
    }
}
