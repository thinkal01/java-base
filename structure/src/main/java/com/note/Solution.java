package com.note;

public class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int water = 0;

        for (int i = 1; i < height.length - 1; ++i) {
            int min = Math.min(leftMax, rightMax);
            if (height[i] < min) {
                water += min - height[i];
            }


        }

        return 0;
    }
}
