package com.note.leetcode.排序_数组;

import org.junit.Test;

/**
 * 将一个字符串中的空格替换成“%20”
 */
public class _04_replace_space {

    @Test
    public void test() {
        System.out.println(replaceSpace("We Are Happy"));
    }

    public String replaceSpace(String str) {
        if (str == null) return null;

        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();

        for (Character c : chars) {
            if (c.equals(' ')) {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
