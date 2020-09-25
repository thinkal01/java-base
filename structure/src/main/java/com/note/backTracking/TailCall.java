package com.note.backTracking;

public class TailCall {

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    /**
     * 尾调用优化
     * 1 * 2 * 3 * 4 * ... * (n - 1) * n
     * @param n
     * @return
     */
    static int factorial(int n) {
        return factorial(n, 1);
    }

    static int factorial(int n, int result) {
        if (n <= 1) return result;
        return factorial(n - 1, result * n);
    }

    static int factorial2(int n) {
        if (n <= 1) return n;
        return n * factorial2(n - 1);
    }
}
