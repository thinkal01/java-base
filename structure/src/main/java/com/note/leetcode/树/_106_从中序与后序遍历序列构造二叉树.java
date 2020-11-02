package com.note.leetcode.树;

import com.note.collection.map.HashMap;
import com.note.collection.map.Map;
import com.note.common.TreeNode;

/**
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    Map<Integer, Integer> valueIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; ++i) {
            valueIndex.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft > inorderRight || postorderLeft > postorderRight) {
            return null;
        }

        int inorderRoot = valueIndex.get(postorder[postorderRight]);
        int leftLen = inorderRoot - inorderLeft - 1;

        TreeNode node = new TreeNode(postorder[postorderRight]);
        node.left = buildTree(inorder, postorder, inorderLeft, inorderRoot - 1, postorderLeft, postorderLeft + leftLen);
        node.right = buildTree(inorder, postorder, inorderRoot + 1, inorderRight, postorderLeft + leftLen + 1, postorderRight - 1);

        return node;
    }

}