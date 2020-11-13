package com.note.leetcode.链表;

import com.note.collection.list.List;
import com.note.collection.list.arrayList.ArrayList;

import java.util.Collections;

public class _0023_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        pre.next = list1 != null ? list1 : list2;
        return preHead.next;
    }
}
