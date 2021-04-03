package com.note.leetcode.排序_数组;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 数组切分4份，和相同
 */
public class 数组切为4等分 {

    public static boolean canSplits1(int[] arr) {
        if (arr == null || arr.length < 7) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int leftSum = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            set.add(leftSum + "_" + (sum - leftSum - arr[i]));
            leftSum += arr[i];
        }

        int l = 1;
        int lsum = arr[0];
        int r = arr.length - 2;
        int rsum = arr[arr.length - 1];

        while (l < r - 3) {
            if (lsum == rsum) {
                String lkey = String.valueOf(lsum * 2 + arr[l]);
                String rkey = String.valueOf(rsum * 2 + arr[r]);
                if (set.contains(lkey + "_" + rkey)) {
                    return true;
                }
                lsum += arr[l++];
            } else if (lsum < rsum) {
                lsum += arr[l++];
            } else {
                rsum += arr[r--];
            }
        }

        return false;
    }

    public static boolean canSplits2(int[] arr) {
        if (arr == null || arr.length < 7) {
            return false;
        }
        // 累加和为key，下标为value
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            map.put(sum, i);
            sum += arr[i];
        }

        int lsum = arr[0];
        for (int s1 = 1; s1 < arr.length - 5; s1++) {
            int checkSum = lsum * 2 + arr[s1];

            // 第一刀
            if (map.containsKey(checkSum)) {
                int s2 = map.get(checkSum);
                checkSum += lsum + arr[s2];
                // 第二刀
                if (map.containsKey(checkSum)) {
                    int s3 = map.get(checkSum);
                    // 第三刀
                    if (checkSum + arr[s3] + lsum == sum) {
                        return true;
                    }
                }
            }

            lsum += arr[s1];
        }

        return false;
    }

    public static int[] generateRondomArray() {
        int[] res = new int[(int) (Math.random() * 10) + 7];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 10) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 3000000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRondomArray();
            if (canSplits1(arr) ^ canSplits2(arr)) {
                System.out.println("Error");
            }
        }
    }
}
