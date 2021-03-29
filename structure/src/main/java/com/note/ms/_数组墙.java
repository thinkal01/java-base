package com.note.ms;

public class _数组墙 {

    public void test() {

    }

    public String maxArea(int[] pos) {
        int[] dp = new int[pos.length];

        for (int i = 0; i < pos.length; ++i) {
            int minIndex = i;
            for (int j = i; j < pos.length; ++j) {
                if (pos[j] < pos[minIndex]) minIndex = j;

            }
        }

        return "";
    }
}
