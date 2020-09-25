package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;

public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
