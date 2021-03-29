package com.note.ms;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _二叉树每层最大值 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.remove();
                if (node.val > max) max = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(max);
        }

        return result;
    }

}
