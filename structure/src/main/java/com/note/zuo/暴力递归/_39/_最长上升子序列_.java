package com.note.zuo.暴力递归._39;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _最长上升子序列_ {


    public static void main(String[] args) {
        int[] nums = new int[]{2,2};

        System.out.println(new _最长上升子序列_().lengthOfLIS(nums));
    }

    class Num{
        int max;
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Num num = new Num();
        int[] cache = new int[nums.length];
        maxLIS(nums, 0,num,cache);
        return num.max;
    }

    public int maxLIS(int[] nums, int index,Num num,int[] cache) {
        if (index == nums.length)
            return 0;
        if (cache[index] > 0) {
            return cache[index];
        }
        int max = 1;
        int n = 0;
        for (int i = index + 1; i < nums.length; i++) {
            n = maxLIS(nums, i,num,cache);
            if (nums[index] < nums[i]) {
                n = n + 1;
                max = max > n ? max : n;
            }
        }
        num.max = num.max > max ? num.max : max;
        cache[index] = max;
        return max;
    }
}
