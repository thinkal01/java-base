package com.note.offer;

import java.util.HashSet;
import java.util.Set;

public class 字符种类 {
    /**
     * 只有小写字符组成的一批字符串,如果两个字符串所含有的字符种类相同,算作一类
     */
    public static int type(String[] strs) {
        Set<Integer> set = new HashSet<>();

        for (String str : strs) {
            // 记录字符种类
            int value = 0;
            for (char c : str.toCharArray()) {
                value |= (1 << (c - 'a'));
            }
            set.add(value);
        }

        return set.size();
    }

    public static int type2(String[] strs) {
        HashSet<String> set = new HashSet<>();
        for (String str : strs) {
            boolean[] contains = new boolean[26];
            for (char c : str.toCharArray()) {
                contains[c - 'a'] = true;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; ++i) {
                if (contains[i]) {
                    sb.append((char) (i + 'a'));
                }
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
