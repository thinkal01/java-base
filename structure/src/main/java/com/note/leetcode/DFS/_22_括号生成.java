package com.note.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) return list;
        dfs(0, n, n, new char[n << 1], list);
        return list;
    }

    /**
     * @param idx         搜索的层号
     * @param leftRemain  左括号的剩余数量
     * @param rightRemain 右括号的剩余数量
     * @param string      用来存放每一层的选择
     */
    private void dfs(int idx, int leftRemain, int rightRemain,
                     char[] string, List<String> list) {
        if (idx == string.length) {
            list.add(new String(string));
            return;
        }

        // 枚举这一层所有可能的选择
        // 选择一种可能之后，进入下一层搜索

        // 什么情况可以选择左括号？左括号的数量 > 0
        // 选择左括号，然后进入下一层搜索
        if (leftRemain > 0) {
            string[idx] = '(';
            dfs(idx + 1, leftRemain - 1, rightRemain, string, list);
        }

        // 当左括号、右括号的数量一样时，只能选择左括号
        // 什么情况可以选择右括号？(右括号的数量 > 0) && (右括号的数量 != 左括号的数量)
        // 选择右括号，然后进入下一层搜索
        if (rightRemain > 0 && leftRemain != rightRemain) {
            string[idx] = ')';
            dfs(idx + 1, leftRemain, rightRemain - 1, string, list);
        }
    }

    public static void main(String[] args) {
        _22_括号生成 o = new _22_括号生成();
        System.out.println(o.generateParenthesis(3));
    }
}

class Solution {

    char[] chars;
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) return list;
        chars = new char[n << 1];
        dfs(0, n, n);
        return list;
    }

    private void dfs(int index, int leftRemain, int rightRemain) {
        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }

        if (leftRemain > 0) {
            // 左括号能放置的位置，左括号不能多于右括号
            for (int i = 0; i <= rightRemain - leftRemain; ++i) {
                for (int j = 0; j < i; ++j) {
                    chars[index + j] = ')';
                }
                chars[index + i] = '(';
                dfs(index + i + 1, leftRemain - 1, rightRemain - i);
            }
        } else {
            chars[index] = ')';
            dfs(index + 1, leftRemain, rightRemain - 1);
        }
    }
}
