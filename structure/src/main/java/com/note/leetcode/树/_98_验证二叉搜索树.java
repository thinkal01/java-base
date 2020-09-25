package com.note.leetcode.树;

import com.note.leetcode.common.TreeNode;
import com.note.stack.Stack;
import org.junit.Test;

/**
 * 判断其是否是一个有效的二叉搜索树
 */
public class _98_验证二叉搜索树 {

    // [3,1,5,0,2,4,6,null,null,null,3]
    @Test
    public void test() {
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(6);

        treeNode5.left = treeNode1;
        treeNode5.right = treeNode4;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode3.left = null;
        treeNode3.right = null;
        treeNode6.left = null;
        treeNode6.right = new TreeNode(3);

        System.out.println(isValidBST(treeNode5));
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 中序遍历以后得到的序列一定是升序序列
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }

        return true;
    }
}
