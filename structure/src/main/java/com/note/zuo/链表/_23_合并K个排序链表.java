package com.note.zuo.链表;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
 */
public class _23_合并K个排序链表 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(8);

        ListNode[] listNodes = {listNode1, listNode2, listNode3};

        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(56);

        listNode2.next = new ListNode(23);
        listNode2.next.next = new ListNode(46);

        listNode3.next = new ListNode(33);
        listNode3.next.next = new ListNode(96);

        ListNode listNode = mergeKLists(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val + ":");
            listNode = listNode.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode newListNode = new ListNode(0);
        ListNode temp = newListNode;
        while (true) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (min > lists[i].val) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (index == -1) {
                return temp.next;
            } else {
                newListNode.next = new ListNode(min);
                newListNode = newListNode.next;
                lists[index] = lists[index].next;
            }
        }
    }

    //以下是方法二 用二分法
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    //通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并
    //通过合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
    private ListNode helper(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }
        int mid = begin + (end - begin) / 2;
        ListNode left = helper(lists, begin, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    //合并两个有序链表
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return (a == null) ? b : a;
        }
        if (a.val <= b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
}

