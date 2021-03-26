package com.note.base;

import org.junit.Test;

public class String01 {

    @Test
    public void test() {
        String s1 = new String("hello");
        String s2 = s1.intern();
        String s3 = "hello";
        String s4 = s1.intern();
        // false
        System.out.println(s1 == s2);
        // true
        System.out.println(s2 == s3);
        // true
        System.out.println(s2 == s4);
    }

    @Test
    public void test01() {
        // 会创建2个对象
        String s1 = new String("hello");
        // 创建1个对象
        String s2 = "hello";

        // 字符串如果是变量相加，先开空间，在拼接
        // 字符串如果是常量相加，是先加，然后在常量池找，如果有就直接返回，否则，就创建
        s1 = "hello";
        s2 = "world";
        String s3 = "helloworld";

        System.out.println(s3 == s1 + s2);// false
        // 通过反编译看源码
        // System.out.println(s3 == "helloworld");
        System.out.println(s3 == "hello" + "world");// true
    }

    public void testCount() {
        String s = "Hello123World";

        //定义三个统计变量
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;

        for (int x = 0; x < s.length(); x++) {
            char ch = s.charAt(x);

            //判断该字符到底是属于那种类型的
            if (ch >= 'a' && ch <= 'z') {
                smallCount++;
            } else if (ch >= 'A' && ch <= 'Z') {
                bigCount++;
            } else if (ch >= '0' && ch <= '9') {
                numberCount++;
            }
        }

        System.out.println("大写字母" + bigCount + "个");
        System.out.println("小写字母" + smallCount + "个");
        System.out.println("数字" + numberCount + "个");
    }

    // 首字母大写
    public void testUpperCaseFirstChar() {
        // 定义一个字符串
        String s = "helloWORLD";
        // 链式编程
        String result = s.substring(0, 1).toUpperCase().concat(s.substring(1).toLowerCase());
    }

    // 用StringBuffer的reverse()功能
    public static String myReverse2(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    // 回文字符串
    public static boolean isSame2(String s) {
        return new StringBuffer(s).reverse().toString().equals(s);
    }

    @Test
    public void testNull() {
        String nullStr = null + ""; // "null"
        nullStr = "123" + null; // "123null"
    }

}
