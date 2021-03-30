package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 两个有序数组相加和最大k个数
 */
public class 两数组和最大k个数 {
    private class Node {
        public int index1;
        public int index2;
        public int value;

        public Node(int index1, int index2, int value) {
            this.index1 = index1;
            this.index2 = index2;
            this.value = value;
        }
    }

    public int[] topKSum(int[] arr1, int[] arr2, int topK) {
        if (arr1.length == 0 || arr2.length == 0 || topK < 0) {
            return new int[0];
        }

        int[] result = new int[topK];
        topK = Math.min(topK, arr1.length * arr2.length);

        // 记录已经访问过的位置
        Set<String> positionSet = new HashSet<>();
        // 最大堆
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((node1, node2) -> node2.value - node1.value);
        // 从右下角开始
        // 第一个数组下标
        int index1 = arr1.length - 1;
        // 第二个数组下标
        int index2 = arr2.length - 1;
        maxHeap.add(new Node(index1, index2, arr1[index1] + arr2[index2]));
        positionSet.add(index1 + "_" + index2);
        int resIndex = 0;

        while (resIndex < topK) {
            Node node = maxHeap.poll();
            result[resIndex++] = node.value;
            index1 = node.index1;
            index2 = node.index2;

            // 当前左边
            if (!positionSet.contains(index1 - 1 + "_" + index2)) {
                positionSet.add(index1 - 1 + "_" + index2);
                maxHeap.add(new Node(index1 - 1, index2, arr1[index1 - 1] + arr2[index2]));
            }
            // 当前上边
            if (!positionSet.contains(index1 + "_" + (index2 - 1))) {
                positionSet.add(index1 + "_" + (index2 - 1));
                maxHeap.add(new Node(index1, (index2 - 1), arr1[index1] + arr2[index2 - 1]));
            }
        }

        return result;
    }

    public static int[] topKSumTest(int[] arr1, int[] arr2, int topK) {
        int[] all = new int[arr1.length * arr2.length];
        int index = 0;
        for (int i = 0; i != arr1.length; i++) {
            for (int j = 0; j != arr2.length; j++) {
                all[index++] = arr1[i] + arr2[j];
            }
        }
        Arrays.sort(all);
        int[] res = new int[Math.min(topK, all.length)];
        index = all.length - 1;
        for (int i = 0; i != res.length; i++) {
            res[i] = all[index--];
        }
        return res;
    }

    public static int[] generateRandomSortArray(int len) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * 50000) + 1;
        }
        Arrays.sort(res);
        return res;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i != arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void main() {
        int a1Len = 5000;
        int a2Len = 4000;
        int k = 2000;
        int[] arr1 = generateRandomSortArray(a1Len);
        int[] arr2 = generateRandomSortArray(a2Len);
        long start = System.currentTimeMillis();
        int[] res = topKSum(arr1, arr2, k);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

        start = System.currentTimeMillis();
        int[] absolutelyRight = topKSumTest(arr1, arr2, k);
        end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

        System.out.println(isEqual(res, absolutelyRight));

    }
}
