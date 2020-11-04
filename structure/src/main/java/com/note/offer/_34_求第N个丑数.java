package com.note.offer;

/**
 * 求从小到大的第 N 个丑数。
 * 丑数是只包含因子 2、3 和 5 的数，习惯上把 1 当做是第一个丑数。
 */
public class _34_求第N个丑数 {
    /**
     * 乘 2 或 3 或 5，之后比较取最小值
     */
    public int getUglyNumber(int n) {
        if (n <= 0) return 0;

        int[] arr = new int[n];
        arr[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < n; ++i) {
            int min = Math.min(arr[multiply2] * 2, Math.min(arr[multiply3] * 3, arr[multiply5] * 5));
            arr[i] = min;
            if (arr[multiply2] * 2 == min) ++multiply2;
            if (arr[multiply3] * 3 == min) ++multiply3;
            if (arr[multiply5] * 5 == min) ++multiply5;
        }

        return arr[n - 1];
    }
}
