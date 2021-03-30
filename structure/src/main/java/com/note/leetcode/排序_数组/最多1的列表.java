package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组左边为0,右边为1
 * 求1数量最多的行
 */
public class 最多1的列表 {
    @Test
    public void test() {
        System.out.println(longestOnes(new int[][]{
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1}}));
    }

    public List<Integer> longestOnes(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int max = 0;
        int n = matrix[0].length;
        int col = n - 1;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][col] == 0) continue;

            int l = 0, r = col;
            while (l <= r) {
                int m = l + r >>> 1;
                if (matrix[i][m] != 1) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            // 最后1的下标
            col = l;

            if (max < n - l) {
                result.clear();
                result.add(i);
                max = n - l;
            } else if (max == n - l) {
                result.add(i);
            }
        }

        return result;
    }
}
