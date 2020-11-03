package com.note.leetcode.排序_数组;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class _33_把数组中的数排成一个最小的数 {

    /**
     * 使用一个比较器的方法，要得到的是一个最小的数字，可以把数拼接成一个字符串。
     * 然后分别去比较，具体的是两两数拼接比较，将形成的数小的数放在前面。
     *
     * @param nums
     * @return
     */
    public String printMinNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        int len = nums.length;
        String[] strs = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            strs[i] = nums[i] + "";
        }

        Arrays.sort(strs, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        });

        for (int i = 0; i < len; ++i) sb.append(strs[i]);
        return sb.toString();
    }
}
