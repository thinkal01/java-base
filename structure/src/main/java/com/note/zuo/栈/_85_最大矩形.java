package com.note.zuo.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class _85_最大矩形 {

    public static void main(String[] args) {
        System.out.println(new _85_最大矩形().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[] oneNums = new int[matrix[0].length + 2];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '0')
                    oneNums[j+1] = 0;
                else
                    oneNums[j+1] ++;
            }
            Stack<Integer> s = new Stack<Integer>();
            for (int j = 0; j < oneNums.length; j++) {
                while (!s.isEmpty() && oneNums[s.peek()] > oneNums[j]) {
                    Integer k = s.pop();
                    max = Math.max(max, oneNums[k] * (j - s.peek() - 1));
                }
                s.push(j);
            }
        }
        return max;

    }
}
