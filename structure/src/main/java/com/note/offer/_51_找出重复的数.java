package com.note.offer;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内，
 * 找出数组中任意一个重复的数字
 */
public class _51_找出重复的数 {

    /**
     * 快慢指针：快慢两个下标都从 0 开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同。
     * 快下标从 0 开始，这两个下标都继续每轮映射一次，当这两个下标相遇时，就是重复的数。或使用辅助空间（HashSet）
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int slow = 0;
        int fast = 0;
        for (int i = 0; i < nums.length; ++i) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) {
                fast = 0;
                while (fast != slow) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return slow;
            }
        }

        return -1;
    }
}
