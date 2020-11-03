package com.note.leetcode.树;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出 Yes,否则输出 No。假设输入的数组的任意两个数字都互不相同。
 */
public class _24_后序遍历二叉搜索树 {

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;

        int rstart = 0;
        int rootIndex = sequence.length - 1;
        // 找出右子树开始位置,左子树值均小于根
        for (int i = 0; i < rootIndex; ++i) {
            if (sequence[i] < sequence[rootIndex]) ++rstart;
        }

        // 只有右子树
        if (rstart == 0) {
            verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, rootIndex));
            return true;
        }

        // 右子树有值小于根，返回false
        for (int i = rstart; i < rootIndex; ++i) {
            if (sequence[i] < sequence[rootIndex]) return false;
        }

        // 含头不含尾
        verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, rstart));
        verifySequenceOfBST(Arrays.copyOfRange(sequence, rstart, rootIndex));
        return true;
    }

}
