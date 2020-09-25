package com.note.leetcode.链表;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 删除链表中等于给定值 val 的所有节点
 */
public class _0203_移除链表元素 {
    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode62 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode6;
        listNode6.next = listNode3;
        listNode3.next = listNode62;

        System.out.println(removeElements(listNode1, 6));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        // 新链表的头结点
        ListNode newHead = new ListNode(0);
        // 新链表的尾结点
        ListNode newTail = newHead;

        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }

        newTail.next = null;
        return newHead.next;
    }
}
