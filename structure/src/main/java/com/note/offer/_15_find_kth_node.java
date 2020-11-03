package com.note.offer;

public class _15_find_kth_node {
    /**
     * 倒数第k个节点
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;

        ListNode fast = head;
        ListNode slow = head;

        /**
         * 快指针走 K 步，然后慢指针开始走，快指针到尾时，慢指针就找到了倒数第 K 个节点
         */
        while (k-- > 1) {
            if (fast.next == null) return null;
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
