package com.note.leetcode.链表;

public class _0019_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        if (fast == null) {
            head=head.next;
        } else {
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
        }

        return head;
    }
}
