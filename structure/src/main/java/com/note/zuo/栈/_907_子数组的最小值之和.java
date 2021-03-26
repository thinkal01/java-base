package com.note.zuo.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 */
public class _907_子数组的最小值之和 {

    public static void main(String[] args) {
        System.out.println(new _907_子数组的最小值之和().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
    public int sumSubarrayMins(int[] A) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int[] newA = new int[A.length + 2];
        int[] sumA = new int[A.length + 2];
        for (int i = 0; i < A.length; i++) {
            newA[i + 1] = A[i];
        }
        stack.push(0);
        for (int i = 1; i < newA.length; i++) {
            while (!stack.isEmpty() && newA[stack.peek()] > newA[i]) {
                 stack.pop();

            }
            sumA[i] = sumA[stack.peek()] + (i - stack.peek()) * newA[i];
            stack.push(i);
        }
        for (int i = 0; i < sumA.length; i++) {
            sum += sumA[i];
            sum = sum % ((int)Math.pow(10,9)+7);

        }
        return sum;

    }
}
