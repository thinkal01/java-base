package com.note.leetcode.链表;

public class _13_delete_node {

    /**
     * O(1)时间删除链表节点
     * 将要删除节点的下一个节点的值赋给要删除的节点，然后指向下下一个节点
     */
    public void deleteNode(ListNode head, ListNode delListNode) {
        if (head == null || delListNode == null) return;

        if (head == delListNode) {
            head = null;
        } else {
            if (delListNode.next == null) {
                ListNode listNode = head;
                while (listNode.next.next != null) {
                    listNode = listNode.next;
                }
                listNode.next = null;
            } else {
                delListNode.val = delListNode.next.val;
                delListNode.next = delListNode.next.next;
            }
        }
    }

}
