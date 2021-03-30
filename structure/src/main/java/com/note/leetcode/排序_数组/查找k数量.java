package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 查找k数量 {
    private Map<Integer, List<Integer>> map;

    /**
     * 查找 l-r,value的数量
     */
    public int query(int[] arr, int l, int r, int value) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        if (!map.containsKey(value)) return 0;

        List<Integer> list = map.get(value);

        // >= l
        int a = find(list, l);
        // > r
        int b = find(list, r + 1);
        return b - a;
    }

    private int find(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = l + r >>> 1;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    @Test
    public void test() {
    }
}
