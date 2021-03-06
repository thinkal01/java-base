package com.note.leetcode.树;

import com.note.common.TreeNode;
import com.note.stack.Stack;

public class _230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode<Integer> root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<Integer> node = root;

        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (--k == 0) {
                return node.val;
            }

            node = node.right;
        }
    }
}
