package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.HashSet;

/**
 * 如果一个数组在排序之后，每相邻两个数差的绝对值 都为 1， 则该数组为可整合数组。
 * 例如，[5,3,4,6,2]排序之后为[2,3,4,5,6]， 符合每相邻两个数差的绝对值都为 1。
 * 给定一个整型数组 arr，请返回其中最大可整合子数组的长度。
 */
public class 可整合数组 {
    public int getLIL2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // 长度
        int result = 0;
        int max = 0;
        int min = 0;
        // 判断元素有没有重复
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                // 区间最大值
                max = Math.max(max, arr[j]);
                // 区间最小值
                min = Math.min(min, arr[j]);
                // 最大值-最小值 = 元素数量
                if (max - min == j - i) {
                    result = Math.max(result, j - i + 1);
                }
            }

            set.clear();
        }

        return result;
    }

    @Test
    public void main() {
        int[] arr = {5, 5, 3, 2, 6, 4, 3};
        System.out.println(getLIL2(arr));
    }

}
