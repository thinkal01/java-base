package com.note.zuo.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739_每日温度 {
    public static void main(String[] args) {
        int[] ints = new _739_每日温度().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] daily = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                Integer pop = stack.pop();
                daily[pop] = i - pop;
            }
            stack.push(i);
        }
        return daily;
    }
}
