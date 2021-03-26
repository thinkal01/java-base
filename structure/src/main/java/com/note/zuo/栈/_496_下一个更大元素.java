package com.note.zuo.栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class _496_下一个更大元素 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], -1);
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int pop = stack.pop();
                map.put(nums2[pop],nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
