package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;

public class _39_二叉树的深度 {

    /**
     * 递归遍历分别返回左右子树深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 平衡二叉树的条件：左子树是平衡二叉树，右子树是平衡二叉树，左右子树高度不超过 1
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean condition = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        return condition && isBalanced(root.left) && isBalanced(root.right);
    }

}
