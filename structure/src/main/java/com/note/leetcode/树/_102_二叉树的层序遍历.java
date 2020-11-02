package com.note.leetcode.树;

import com.note.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode<Integer> node = queue.remove();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(levelList);
        }

        return result;
    }
}
