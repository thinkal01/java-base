package com.note.problem;

import java.util.HashMap;

/**
 * 2、给定一个数组，值可以为正、负和0，请返回累加和为给定值k的最长子数组长度。
 */
public class Problem_04_LongestSumSubArrayLength {

    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // important
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // k=sum-(sum-k)
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            // map中不包含该和时,加入map
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        // int[] arr = generateArray(20);
        int[] arr = new int[]{0, -1, 5, -5, 11};
        printArray(arr);
        System.out.println(maxLength(arr, 10));
    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
