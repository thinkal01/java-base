package com.note.leetcode.链表;

public class _57_删除链表中重复的节点 {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null) return null;

        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode p = head;
        ListNode preNode = first;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                // 上一个非重复值指向下一个非重复值
                preNode.next = p;
            } else {
                preNode = p;
                p = p.next;
            }
        }

        return first.next;
    }
}
