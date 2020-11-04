package com.note.leetcode.字符串;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 找到第一个只出现一次的字符,并返回它的位置
 */
public class _35_第一个出现一次的字符 {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;

        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char item : chars) {
            if (map.containsKey(item)) map.put(item, map.get(item) + 1);
            else map.put(item, 1);
        }

        for (int i = 0; i < str.length(); ++i)
            if (map.get(str.charAt(i)) == 1) return i;

        return -1;
    }
}
