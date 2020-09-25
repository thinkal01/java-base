package com.note.recursion;

public class Recursion01 {
    // 递归求和
    public static int getSum(int num) {
        if (num == 1)
            return 1;
        return num + getSum(num - 1);
    }

    // 递归转二进制
    public static void toBin(int num) {
        if (num > 0) {
            toBin(num / 2);
            System.out.println(num % 2);
        }
    }

    // 阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
