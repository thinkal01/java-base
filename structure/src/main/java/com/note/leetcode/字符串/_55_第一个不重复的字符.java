package com.note.leetcode.字符串;

/**
 * 找出字符流中第一个只出现一次的字符
 */
public class _55_第一个不重复的字符 {
    public char findFirstAppearingOnce(String str) {
        if (str == null || str.length() == 0) return '#';

        char[] chars = str.toCharArray();
        // 借助辅助数组
        char[] charCount = new char[256];
        for (char c : chars) {
            ++charCount[c];
        }

        for (char c : chars) {
            if (charCount[c] == 1) {
                return c;
            }
        }

        return '#';
    }
}
