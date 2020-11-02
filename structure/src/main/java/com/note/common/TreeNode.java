package com.note.common;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent = null;

    public TreeNode(T x) {
        val = x;
    }

}
