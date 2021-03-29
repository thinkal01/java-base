package com.note.leetcode.链表;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
