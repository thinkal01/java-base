package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _101_对称二叉树 {
    public boolean isSymmetric3(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        LinkedList<TreeNode> leftList = new LinkedList<>();
        leftList.add(left);
        LinkedList<TreeNode> rightList = new LinkedList<>();
        rightList.add(right);

        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            left = leftList.remove(0);
            right = rightList.remove(0);
            if (left == null && right == null) {
            } else if (left != null && right != null && left.val == right.val) {
            } else {
                return false;
            }

            if (left != null) {
                leftList.add(left.left);
            }
            if (left != null) {
                leftList.add(left.right);
            }

            if (right != null) {
                rightList.add(right.right);
            }
            if (right != null) {
                rightList.add(right.left);
            }
        }

        return leftList.isEmpty() && rightList.isEmpty();
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}
