package com.note.leetcode.排序_数组;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class 左旋转字符串 {
    @Test
    public void test01() {
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverseLeftWords(chars, n, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverseLeftWords(char[] chars, int n, int start, int end) {
        if (start + n > end) return;

        if (n <= (end - start + 1 >>> 1)) {
            int l = start, r = start + n;
            for (; l < start + n; ++l, ++r) {
                swap(chars, l, r);
            }
            reverseLeftWords(chars, n, start + n, end);
        } else {
            int l = start + n - 1, r = end;
            for (; r > start + n - 1; --l, --r) {
                swap(chars, l, r);
            }
            reverseLeftWords(chars, (2 * n - end + start - 1), start, start + n - 1);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
