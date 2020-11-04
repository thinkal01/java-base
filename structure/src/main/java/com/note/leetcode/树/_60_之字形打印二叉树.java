package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 第一行按照从左到右的顺 序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，依此类推。
 */
public class _60_之字形打印二叉树 {
    public List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (depth % 2 == 0) {
                    tmp.add(node.val);
                } else {
                    tmp.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
            ++depth;
        }

        return res;
    }
}
