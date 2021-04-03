package com.note.leetcode.动态规划;

/**
 * 求从小到大的第 N 个丑数。
 * 丑数是只包含因子 2、3 和 5 的数，习惯上把 1 当做是第一个丑数。
 */
public class 丑数 {
    public int getUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 1; i < n; ++i) {
            result[i] = Math.min(result[i2] * 2, Math.min(result[i3] * 3, result[i5] * 5));
            if (result[i] == result[i2] * 2) {
                ++i2;
            }
            if (result[i] == result[i3] * 3) {
                ++i3;
            }
            if (result[i] == result[i5] * 5) {
                ++i5;
            }
        }

        return result[n - 1];
    }

    public boolean isUgly(int num) {
        while (num != 1) {
            if (num % 3 == 0)
                num = num / 3;
            else if (num % 5 == 0)
                num = num / 5;
            else if (num % 2 == 0)
                num = num / 2;
            else
                return false;
        }

        return true;
    }
}
