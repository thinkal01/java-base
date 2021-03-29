package com.note;

import com.note.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test15 {

    @Test
    public void test01() {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;

        pathSum(treeNode5, 22);
    }

    List<List<Integer>> result = new ArrayList<>();
    int[] nums = new int[10000];
    int len = 0;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return result;

        List<Integer> list = new ArrayList<>();
        nums[len++] = root.val;
        int sum = target;
        for (int i = len - 1; i >= 0; --i) {
            sum -= nums[i];
            list.add(nums[i]);
        }

        if (sum == 0) {
            result.add(new ArrayList(list));
        }

        pathSum(root.left, target);
        pathSum(root.right, target);
        --len;

        return result;
    }
}

