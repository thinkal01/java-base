package com.note.offer;

/**
 * arr子序列和 % m 最大值
 */
public class 取余最大值 {

    /**
     * arr和很小,m很大
     */
    public int max(int[] arr, int m) {
        int sum = 0;
        int n = arr.length;
        for (int num : arr) {
            sum += num;
        }

        // 0-i 的数组和
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                // 不选第i位
                dp[i][j] = dp[i - 1][j];
                // 选择第i位
                if (j - arr[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - arr[i]];
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= sum; ++i) {
            if (dp[n - 1][i]) {
                result = Math.max(result, i % m);
            }
        }

        return result;
    }

    /**
     * arr和很大,m很小
     */
    public int max2(int[] arr, int m) {
        int n = arr.length;
        // 数组前i位 % m 的值
        boolean[][] dp = new boolean[n][m];
        for (int i = 0; i < m; ++i) {
            dp[i][0] = true;
        }
        dp[0][arr[0] % m] = true;

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                // 不选第i位
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - arr[i]];
                }
                if (m + j - arr[i] < m) {
                    dp[i][j] |= dp[i - 1][m + j - arr[i]];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; ++i) {
            if (dp[n - 1][i]) {
                result = i;
            }
        }

        return result;
    }

}
