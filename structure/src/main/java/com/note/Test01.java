package com.note;

import org.junit.Test;

public class Test01 {
    @Test
    public void test() {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int first = -1, second = 0, max;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                first = find(nums, 0, i - 1, nums[i]);
                second = i;
                break;
            }
        }

        if (first == -1) return 0;
        max = second - 1;
        for (int i = second + 1; i < nums.length; ++i) {
            if (nums[i] < nums[first]) {
                first = find(nums, 0, first, nums[i]);
                second = i;
            }
            if (nums[i] < nums[max]) {
                second = i;
            } else {
                max = i;
            }
        }

        return first == -1 ? 0 : second - first + 1;
    }

    private int find(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= target) {
                ++l;
            } else {
                --r;
            }
        }

        return l;
    }
}