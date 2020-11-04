package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class _25_二叉树中和为某值的路径 {
    private List<List<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int target) {
        if (root == null) return listAll;

        list.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(list);
            listAll.add(tmpList);
        }

        findPath(root.left, target);
        findPath(root.right, target);

        // 回退
        list.remove(list.size() - 1);
        return listAll;
    }

}
