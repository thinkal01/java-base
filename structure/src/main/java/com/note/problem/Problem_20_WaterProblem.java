package com.note.problem;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 3,1,2,4,代表这个容器可以装3格水
 */
public class Problem_20_WaterProblem {

    public static int getWater1(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int value = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(arr[l], leftMax);
            }
            for (int r = i + 1; r < arr.length; r++) {
                rightMax = Math.max(arr[r], rightMax);
            }
            value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }

        return value;
    }

    public static int getWater2(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int n = arr.length - 2;
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = arr[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i + 2]);
        }

        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += Math.max(0, Math.min(leftMax[i - 1], rightMax[i - 1]) - arr[i]);
        }

        return value;
    }

    public static int getWater3(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int n = arr.length - 2;
        int[] rightMax = new int[n];
        rightMax[n - 1] = arr[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i + 2]);
        }

        int leftMax = arr[0];
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += Math.max(0, Math.min(leftMax, rightMax[i - 1]) - arr[i]);
            leftMax = Math.max(leftMax, arr[i]);
        }

        return value;
    }

    public static int getWater4(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int value = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int l = 1;
        int r = arr.length - 2;

        /**
         * 计算左右两边最大值中的较小值,减去当前节点高度,即为当前节点水容量
         */
        while (l <= r) {
            if (leftMax <= rightMax) {
                value += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                value += Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }

        return value;
    }

    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 98) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) + 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = generateRandomArray();
            int r1 = getWater1(arr);
            int r2 = getWater2(arr);
            int r3 = getWater3(arr);
            int r4 = getWater4(arr);
            if (r1 != r2 || r3 != r4 || r1 != r3) {
                System.out.println("What a fucking day! fuck that! man!");
            }
        }

        HashMap<String, String> map = new HashMap<>();

        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }
    }

}
