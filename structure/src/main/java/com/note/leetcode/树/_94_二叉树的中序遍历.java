package com.note.leetcode.树;

import com.note.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _94_二叉树的中序遍历 {
    @Test
    public void test() {

    }

    public List<Integer> inorderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode<Integer> node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }
}
