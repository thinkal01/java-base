package com.note.leetcode.链表;

/**
 * 链表的环的入口结点
 */
public class _56_链表中环的入口节点 {
    /**
     * 定义快慢两个指针，相遇后（环中相汇点）将快指针指向 pHead 然后一起走，
     * 每次往后挪一位，相遇的节点即为所求。
     * 详细分析：相遇即 p1==p2 时，p2 所经过节点数为 2x,p1 所经过节点数为 x,
     * 设环中有 n 个节点,p2 比 p1 多走a圈有 2x=an+x; an=x;
     * 可以看出 p1 实际走了a个环的步数，再让 p2 指向链表头部，p1 位置不变，
     * p1,p2 每次走一步直到 p1==p2; 此时 p1 指向环的入口。
     */
    public ListNode entryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                if (slow == fast) return slow;
            }
        }

        return null;
    }
}
