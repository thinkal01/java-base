package com.note.offer;

/**
 * 数二进制表示中 1 的个数
 */
public class _10_number_of_1 {

    /**
     * a&(a-1)的结果会将 a 最右边的 1 变为 0，直到 a = 0
     * 还可以将 a&1 != 0，然后右移 1 位，但不能计算负数的值
     */
    public int numberOf1(int n) {
        int count = 0;

        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }

        return count;
    }
}
