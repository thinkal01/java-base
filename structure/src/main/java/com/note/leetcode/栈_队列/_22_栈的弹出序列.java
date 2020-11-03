package com.note.leetcode.栈_队列;

import java.util.Stack;

/**
 * 假设压入栈的所有数字均不相等。例如序列 1,2,3,4,5 是某栈的压入顺序，
 * 序列 4，5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 */
public class _22_栈的弹出序列 {

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) return false;

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; ++i) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                ++index;
            }
        }

        return stack.isEmpty();
    }
}
