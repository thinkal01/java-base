package com.note.offer;

/**
 * 对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出
 * 例如，字符序列S=”abcXYZdef”,输出循环左移3位后的结果，即“XYZdefabc”
 */
public class _42_字符串循环左移K位 {

    public String leftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return str;

        String s1 = reverse(str.substring(0, n));
        String s2 = reverse(str.substring(n, str.length()));
        return reverse(s2) + reverse(s1);
    }

    public String reverse(String str) {
        char[] a = new char[str.length()];

        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            a[j] = str.charAt(i);
            a[i] = str.charAt(j);
        }

        return String.valueOf(a);
    }

}
