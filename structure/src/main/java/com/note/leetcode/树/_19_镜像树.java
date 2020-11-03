package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 给定的二叉树，将其变换为源二叉树的镜像。
 */
public class _19_镜像树 {

    /**
     * 使用递归或非递归方式交换每个节点的左右子树位置。
     */
    public void mirror(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        // 先序遍历的变形
        mirror(root.left);
        mirror(root.right);
    }

    public void mirror2(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
