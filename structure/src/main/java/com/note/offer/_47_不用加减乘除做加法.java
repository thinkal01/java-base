package com.note.offer;

/**
 * 求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 */
public class _47_不用加减乘除做加法 {
    public int add(int num1, int num2) {
        while (num2 != 0) {
            // 计算个位
            int temp = num1 ^ num2;
            // 计算进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }

        return num1;
    }
}
