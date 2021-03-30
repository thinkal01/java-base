package com.note.leetcode.DFS;

import org.junit.Test;

/**
 * 输入数字 n，按顺序打印从 1 到最大的 n 位数十进制数，
 * 比如：输入 3，打印出 1 到 999.
 */
public class _12_print_max_n {
    @Test
    public void test() {
        printToMaxOfNDigits(3);
    }

    public void printToMaxOfNDigits(int n) {
        int[] array = new int[n];
        if (n <= 0) return;
        printArray(array, 0);
    }

    /**
     * 采用dfs
     */
    private void printArray(int[] array, int n) {
        for (int i = 0; i < 10; ++i) {
            if (n != array.length) {
                array[n] = i;
                printArray(array, n + 1);
            } else {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; ++j) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
                        // 从第一个非0元素开始打印
                        if (!isFirstNo0) isFirstNo0 = true;
                    } else {
                        if (isFirstNo0) System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }
}
