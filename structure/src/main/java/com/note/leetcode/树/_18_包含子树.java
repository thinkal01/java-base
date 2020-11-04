package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;

public class _18_包含子树 {

    public boolean hasSubTree(TreeNode source, TreeNode target) {
        if (target == null || source == null) return false;

        if (doesTree1HaveTree2(source, target)) return true;

        return hasSubTree(source.left, target) || hasSubTree(source.right, target);
    }

    public boolean doesTree1HaveTree2(TreeNode source, TreeNode target) {
        if (source == null && target == null) return true;
        if (source == null || target == null) return false;

        if (source.val != target.val) return false;
        return doesTree1HaveTree2(source.left, target.left) && doesTree1HaveTree2(source.right, target.right);
    }
}
