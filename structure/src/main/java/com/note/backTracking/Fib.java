package com.note.backTracking;

import com.note.tools.Times;

public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        int n = 45;
        Times.test("fib0", () -> {
            System.out.println(fib.fib0(n));
        });
        Times.test("fib1", () -> {
            System.out.println(fib.fib1(n));
        });
        Times.test("fib2", () -> {
            System.out.println(fib.fib2(n));
        });
        Times.test("fib3", () -> {
            System.out.println(fib.fib3(n));
        });
    }

    /**
     * 简单递归
     * @param n
     * @return
     */
    int fib0(int n) {
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    int fib1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n, array);
    }

    /**
     * 使用数组存放计算结果
     * @param n
     * @param array
     * @return
     */
    int fib1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = fib1(n - 1, array) + fib1(n - 2, array);
        }
        return array[n];
    }

    /**
     * 非递归优化
     * @param n
     * @return
     */
    int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 使用滚动数组
     * @param n
     * @return
     */
    int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }

    /**
     * 使用位运算取代模运算
     * 4 % 2 = 0  0b100 & 0b001 = 0
     * 3 % 2 = 1  0b011 & 0b001 = 1
     * 5 % 2 = 1  0b101 & 0b001 = 1
     * 6 % 2 = 0  0b110 & 0b001 = 0
     */
    int fib4(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }
}
