package com.note.zuo.链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 属于简单类型 只需要把各种情况考虑进去即可
 */
public class _2_两数相加 {

    /**
     * 非递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newListNode = new ListNode(0);
        ListNode temp = newListNode;
        int carray = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carray;
            newListNode.next = new ListNode(sum % 10);
            newListNode = newListNode.next;
            carray = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carray>0)  newListNode.next = new ListNode(carray);
        return temp.next;
    }

    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int a) {
        if(l1 == null && l2 == null && a == 0) return null;
        if(l1 == null) l1 = new ListNode(0);
        if(l2 == null) l2 = new ListNode(0);
        int sum = l1.val + l2.val + a;
        ListNode head = new ListNode(sum % 10);
        head.next = add(l1.next, l2.next, sum / 10);
        return head;
    }

}
