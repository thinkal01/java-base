package com.note.offer;

/**
 * 圆圈中最后剩下的数字（约瑟夫环）
 */
public class _45_圆圈中最后剩下的数 {
    public int lastRemain(int n, int k) {
        if (n < 1 || k < 1) return -1;

        int last = 0;
        for (int i = 2; i <= n; ++i) {
            // i 个人时删除数的索引等于 i-1 个人时删除数的索引+k(再对 i 取余)
            last = (last + k) % i;
        }

        return last;
    }
}
