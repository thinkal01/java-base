package com.note.problem;

/**
 * 找出不相交的两个子数组
 * 求两个子数组最大和
 */
public class Problem_32_TwoSubArrayMaxSum {

    public static int twoSubArrayMaxSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int[] rArray = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            cur += arr[i];
            max = Math.max(max, cur);
            rArray[i] = max;
            cur = cur < 0 ? 0 : cur;
        }

        int res = Integer.MIN_VALUE;
        max = Integer.MIN_VALUE;
        cur = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            res = Math.max(res, max + rArray[i + 1]);
            cur = cur < 0 ? 0 : cur;
        }

        return res;
    }

    public static int rightAnswer(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        for (int p = 0; p < arr.length - 1; p++) {
            res = Math.max(res, maxSum(arr, 0, p) + maxSum(arr, p + 1, arr.length - 1));
        }

        return res;
    }

    public static int maxSum(int[] arr, int l, int r) {
        int max = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = l; i <= r; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }

        return max;
    }

    public static int[] generateRandomArray() {
        int[] res = new int[(int) (Math.random() * 10) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 20) - 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 5000000;
        boolean hasErr = false;
        for (int i = 0; i < testTime; i++) {
            int[] test = generateRandomArray();
            if (twoSubArrayMaxSum(test) != rightAnswer(test)) {
                hasErr = true;
            }
        }

        if (hasErr) {
            System.out.println("23333333");
        } else {
            System.out.println("66666666");
        }
    }

}
