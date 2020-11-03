package com.note.leetcode.字符串;

import org.junit.Test;

/**
 * 匹配包括'.'和'*'的正则表达式
 */
public class _55_正则表达式匹配 {

    @Test
    public void test() {
        System.out.println(isMatch("abc", "abc*"));
    }

    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray(), ptr = p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];
        dp[0][0] = true;

        for (int i = 0; i <= str.length; i++) {
            for (int j = 1; j <= ptr.length; j++) {
                if (ptr[j - 1] != '*') {
                    if (i > 0 && (str[i - 1] == ptr[j - 1] || ptr[j - 1] == '.')) dp[i][j] = dp[i - 1][j - 1];
                } else { //ptr[j - 1] == '*'
                    if (j > 1) dp[i][j] |= dp[i][j - 2];   //不看
                    if (i > 0 && j > 1 && (str[i - 1] == ptr[j - 2] || ptr[j - 2] == '.'))
                        dp[i][j] |= dp[i - 1][j];    //看
                }
            }
        }

        return dp[str.length][ptr.length];
    }

    public boolean isMatch3(String s, String p) {
        int m = s.length();
        int n = p.length();

        char[] chars = s.toCharArray();
        char[] pchars = p.toCharArray();
        // f[i][j] 表示 s 的前 i 个字符与 p 的前 j 个字符是否能够匹配
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public boolean isMatch2(String s, String p) {
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();

        if (chars.length == 1 && pattern.length == 1) {
            if (chars[0] == pattern[0] || pattern[0] == '.') {
                return true;
            }

            return false;
        }

        int sindex = 0;
        int pindex = 0;
        return matchIndex(chars, sindex, pattern, pindex);
    }

    private boolean matchIndex(char[] chars, int sindex, char[] pattern, int pindex) {
        // chars和pattern同时到达末尾
        if (sindex == chars.length && pindex == pattern.length) return true;
        // 若pattern先到末尾，chars没到
        if (sindex != chars.length && pindex == pattern.length) return false;
        // pattern第二个字符是*
        if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
            // 当前字符相等
            if (sindex != chars.length && pattern[pindex] == chars[sindex] ||
                    sindex != chars.length && pattern[pindex] == '.') {
                // 字符串后移一位，模式后移两位，匹配一个字符
                return matchIndex(chars, sindex + 1, pattern, pindex + 2)
                        // 字符串后移两位，模式被忽略，匹配0个字符
                        || matchIndex(chars, sindex, pattern, pindex + 2)
                        // 字符串后移一位，模式不变，匹配多个字符
                        || matchIndex(chars, sindex + 1, pattern, pindex);
            } else {
                // 当前字符不相等，后移两位继续匹配
                return matchIndex(chars, sindex, pattern, pindex + 2);
            }
        }

        // pattern第二个字符不是*
        if (sindex != chars.length && pattern[pindex] == chars[sindex] ||
                sindex != chars.length && pattern[pindex] == '.')
            // 继续匹配下一个字符
            return matchIndex(chars, sindex + 1, pattern, pindex + 1);

        return false;
    }
}
