package com.note;

import org.junit.Test;

public class Test02 {
    /**
     * 求 a+b 的中位数
     */
    @Test
    public void test() {
        int a = Integer.MAX_VALUE - 10;
        int b = Integer.MAX_VALUE - 20;
        // + 优先级高于 >>>
        System.out.println(a + b >>> 1);
        System.out.println(a + (b - a >> 1));
        System.out.println(a + b >> 1);
    }

    /**
     * 删除sb字符
     */
    public void test2() {
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(sb.length() - 1);
    }
}
