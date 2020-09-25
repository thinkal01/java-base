package com.note.leetcode.字符串;

/**
 * https://leetcode-cn.com/problems/flipped-string-lcci/
 * 给定两个字符串s1和s2，检查s2是否为s1旋转而成
 * （比如，waterbottle是erbottlewat旋转后的字符串）
 */
public class _01_09_字符串轮转 {

    // KMP
    // 旋转词
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        // 这里还可以考虑使用KMP算法
        return (s1 + s1).contains(s2);
    }
}
