package com.note.leetcode.链表;

import com.note.leetcode.链表.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表每个节点的值
 */
public class _05_print_list {

    /**
     * 借助栈实现，或使用递归的方法。
     */
    public List<Integer> printListFromTailToHead(ListNode headNode) {
        List<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();

        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }

        return list;
    }

    public static ArrayList<Integer> printListReverse2(ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if (headNode != null) {
            if (headNode.next != null) {
                list = printListReverse2(headNode.next);
            }
            list.add(headNode.val);
        }

        return list;
    }
}
