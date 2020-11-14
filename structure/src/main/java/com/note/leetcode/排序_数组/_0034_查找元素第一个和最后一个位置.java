package com.note.leetcode.排序_数组;

public class _0034_查找元素第一个和最后一个位置 {
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                // 左边位置
                int leftIdx = middle;
                int hil = middle - 1, lol = left;
                while (lol <= hil) {
                    middle = (lol + hil) >> 1;
                    if (nums[middle] < target) {
                        lol = middle + 1;
                    } else if (nums[middle] == target) {
                        leftIdx = middle;
                        hil = middle - 1;
                    }
                }

                // 右边位置
                int rightIdx = middle;
                int lor = middle + 1, hir = right;
                while (lor <= hir) {
                    middle = (lor + hir) >> 1;
                    if (nums[middle] > target) {
                        hir = middle - 1;
                    } else if (nums[middle] == target) {
                        rightIdx = middle;
                        lor = middle + 1;
                    }
                }

                return new int[]{leftIdx, rightIdx};
            }
        }

        return new int[]{-1, -1};
    }
}
