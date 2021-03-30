package com.note.leetcode.字符串;

public class 寻找异位子串 {
    public int find(String str, String aim) {
        if (str.length() < aim.length()) return -1;

        int[] counts = new int[256];
        for (char c : aim.toCharArray()) {
            ++counts[c];
        }

        char[] chars = str.toCharArray();
        // 多扣除的字符数
        int validTime = 0;
        int i = 0;
        int m = aim.length();
        for (; i < m; ++i) {
            if (--counts[chars[i]] < 0) {
                ++validTime;
            }
        }

        for (; i < chars.length; ++i) {
            if (validTime == 0) {
                return i - m;
            }
            if (--counts[chars[i]] < 0) {
                ++validTime;
            }
            if (++counts[chars[i - m]] <= 0) {
                --validTime;
            }
        }

        return validTime == 0 ? i - m : -1;
    }
}
