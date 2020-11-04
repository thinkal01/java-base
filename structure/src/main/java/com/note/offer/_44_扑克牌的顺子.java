package com.note.offer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
 * 2~10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，大小王为0可以看成任意数字。
 */
public class _44_扑克牌的顺子 {

    /**
     * 用数组记录五张扑克牌，将数组调整为有序的，
     * 若 0 出现的次数>=顺子的 差值，即为顺子。
     */
    public boolean isContinuous(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int count = 0;
        int diff = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == 0) {
                ++count;
                continue;
            }
            if (nums[i] == nums[i + 1]) return false;

            diff += nums[i + 1] - nums[i] - 1;
        }

        return diff <= count;
    }
}
