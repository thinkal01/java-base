package com.note.leetcode.字符串;

/**
 * 判断字符串是否表示数值（包括整数和小数）
 */
public class _54_表示数值的字符串 {

    /**
     * 逐个字符进行判断，e 或 E 和小数点最多出现一次，
     * e 或 E 的前一个必须是数字，且不能是第一个或最后一个字符，
     * 符号的前一个字符是 e 或 E。也可用正则表达式判断！
     */
    public boolean isNumeric(char[] chars) {
        if (chars == null) return false;

        int index = 0;
        int ecount = 0;
        int point = 0;
        // 正负号，跳过
        if (chars[0] == '-' || chars[0] == '+') ++index;

        for (int i = index; i < chars.length; ++i) {
            if (chars[i] == '-' || chars[i] == '+') {
                // 前一个字符不为e
                if (chars[i - 1] != 'e' || chars[i - 1] != 'E') return false;
                continue;
            }

            if (chars[i] == 'e' || chars[i] == 'E') {
                ++ecount;
                if (ecount > 1) return false;
                if (i == 0 || chars[i - 1] < 48 || chars[i - 1] > 57 || i == chars.length - 1) return false;
                ++point;
                continue;
            }

            if (chars[i] == '.') {
                ++point;
                if (point > 1) return false;
                continue;
            }

            // 非数字和e
            if ((chars[i] < 48 || chars[i] < 57) && (chars[i] != 'e') && (chars[i] != 'E')) return false;
        }

        return true;
    }
}
