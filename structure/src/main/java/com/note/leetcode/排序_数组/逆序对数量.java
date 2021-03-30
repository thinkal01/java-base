package com.note.leetcode.排序_数组;

import java.util.Arrays;

public class 逆序对数量 {
    public int[] reversePair(int[] originArr, int[] reverseArr, int power) {
        int[] originReverse = Arrays.copyOf(originArr, originArr.length);
        // 逆序数组
        // reversePart(originReverse, 0, originReverse.length - 1);
        // 2的i次方划分,降序的数量
        int[] recordDown = new int[power + 1];
        // 2的i次方划分,升序的数量
        int[] recordUp = new int[power + 1];
        process(originArr, 0, originArr.length - 1, power, recordDown);
        process(originReverse, 0, originReverse.length - 1, power, recordUp);

        int[] result = new int[reverseArr.length];
        for (int i = 0; i < reverseArr.length; ++i) {
            int curPower = reverseArr[i];
            // 交换逆序,顺序对数量
            for (int j = 1; i <= curPower; ++j) {
                int temp = recordDown[j];
                recordDown[j] = recordUp[j];
                recordUp[j] = temp;
            }

            for (int j = 0; j <= power; ++j) {
                result[i] += recordDown[j];
            }
        }

        return result;
    }

    private void process(int[] originArr, int i, int n, int power, int[] recordDown) {

    }

    private int merge(int[] arr, int l, int m, int r) {
        return 0;
    }
}
