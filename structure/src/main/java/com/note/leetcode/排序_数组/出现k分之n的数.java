package com.note.leetcode.排序_数组;

import java.util.*;

public class 出现k分之n的数 {
    /**
     * arr中出现次数 > n/k 的数
     */
    public List<Integer> kMajor(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        if (k < 2) {
            return result;
        }

        // 候选-出现次数
        Map<Integer, Integer> candMap = new HashMap<>();
        for (int num : arr) {
            if (candMap.containsKey(num)) {
                candMap.put(num, candMap.get(num) + 1);
            } else {
                if (candMap.size() == k - 1) {
                    // 一次删掉k个不同的数
                    allCandMinusOne(candMap);
                } else {
                    candMap.put(num, 1);
                }
            }
        }

        candMap = getCandTime(arr, candMap);
        for (Map.Entry<Integer, Integer> entry : candMap.entrySet()) {
            if (entry.getValue() > arr.length / k) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    /**
     * 候选map中所有值-1
     */
    private void allCandMinusOne(Map<Integer, Integer> candMap) {
        Iterator<Map.Entry<Integer, Integer>> iterator = candMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int value = entry.getValue() - 1;
            if (value == 0) {
                iterator.remove();
            } else {
                entry.setValue(value);
            }
        }
    }

    /**
     * 获取候选在数组中出现次数
     */
    private Map<Integer, Integer> getCandTime(int[] arr, Map<Integer, Integer> candMap) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (candMap.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return map;
    }
}
