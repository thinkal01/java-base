package com.note.leetcode.排序_数组;

import org.junit.Test;

public class _0004_两个正序数组的中位数 {
    @Test
    public void test() {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int first = (n + m + 1) / 2;
        int second = (n + m + 2) / 2;

        if (first == second) {
            // 奇数
            return getKth(nums1, 0, n - 1, nums2, 0, m - 1, first);
        } else {
            // 偶数
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, first) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, second)) * 0.5;
        }
    }

    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 == 0) return nums2[start2 + k - 1];
        if (len2 == 0) return nums1[start1 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int mid1 = -1;
        int mid2 = -1;
        if (nums1 == null || nums1.length == 0) {
            mid1 = nums2.length / 2;
            mid2 = nums2.length % 2 == 0 ? mid1 - 1 : -1;

            return (nums2[mid1] + (mid2 == -1 ? nums2[mid1] : nums2[mid2])) / 2.0;
        }

        if (nums2 == null || nums2.length == 0) {
            mid1 = nums1.length / 2;
            mid2 = nums1.length % 2 == 0 ? mid1 - 1 : -1;

            return (nums1[mid1] + (mid2 == -1 ? nums1[mid1] : nums1[mid2])) / 2.0;
        }

        mid1 = (nums1.length + nums2.length) / 2;
        mid2 = (nums1.length + nums2.length) % 2 == 0 ? mid1 - 1 : -1;

        int i = 0;
        int j = 0;
        int index = 0;
        int val = 0;
        while (i < nums1.length || j < nums2.length) {
            if (j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                if (index == mid1) {
                    if (mid2 == -1) {
                        return nums1[i];
                    }

                    return (nums1[i] + val) / 2.0;
                }
                val = nums1[i];
                ++i;
            } else {
                if (index == mid1) {
                    if (mid2 == -1) {
                        return nums2[j];
                    }

                    return (nums2[j] + val) / 2.0;
                }
                val = nums2[j];
                ++j;
            }

            ++index;
        }

        return 0;
    }
}
