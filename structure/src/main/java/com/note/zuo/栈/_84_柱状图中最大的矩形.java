package com.note.zuo.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class _84_柱状图中最大的矩形 {
    public static void main(String[] args) {
        System.out.println(new _84_柱状图中最大的矩形().largestRectangleArea(new int[]{1}));

    }

    public int largestRectangleArea(int[] heights) {
        //声明一个栈
        Stack<Integer> stack = new Stack<Integer>();
        //在这里用哨兵  为这个数组头和尾填加一个0 后面遍历的时候 会把栈中的所有元素都弹出来 不需要再额外的操作了
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i+1] = heights[i];
        }
        //记录最大值
        int sum = 0;
        //遍历数组中的每一个元素
        for (int i = 0; i < newHeights.length; i++) {
            //如果栈顶元素大于当前要入栈的元素 破坏了单调原则 也说明这个栈顶元素已经找到了他的右边第一个小于他的值了
            while (!stack.isEmpty() &&newHeights[stack.peek()] > newHeights[i]){
                //把这个元素弹出来
                int k = stack.pop();
                //k表示要弹出的元素 i表示右边第一个小于k的值 stack.peek也就是栈顶元素 表示左边第一个小于他的值
                //长度注意要-1
                //求最大大的
                sum = Math.max(sum, newHeights[k] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return sum;
    }

}
