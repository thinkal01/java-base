package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 生成达标数组 {
    /**
     * 对应任意 i<k<j,满足 arr[i]+arr[j] != arr[k]*2
     */
    public int[] makeNo(int size) {
        if (size == 1) {
            return new int[]{1};
        }

        int halfSize = (size + 1) >> 1;
        int[] base = makeNo(halfSize);

        int[] result = new int[size];
        int i = 0;
        // 奇数
        for (; i < halfSize; ++i) {
            result[i] = base[i] * 2 - 1;
        }
        // 偶数
        for (; i < size; ++i) {
            result[i] = base[i - halfSize] * 2;
        }

        return result;
    }

    @Test
    public void test() {
        for (int i = 1; i < 20; ++i) {
            System.out.println(Arrays.toString(makeNo(i)));
        }
    }
}
