package com.note.leetcode.树;

import com.note.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _297_二叉树的序列化与反序列化 {
    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        String data = serialize(treeNode1);
        System.out.println(data);
        TreeNode root = deserialize(data);
        // System.out.println(root);

        Codec codec = new Codec();
        data = codec.serialize(treeNode1);
        System.out.println(data);
    }

    public class Codec {
        /**
         * 前序遍历
         */
        public String rserialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += str.valueOf(root.val) + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }

        public TreeNode rdeserialize(List<String> l) {
            if (l.get(0).equals("None")) {
                l.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(l.remove(0)));
            root.left = rdeserialize(l);
            root.right = rdeserialize(l);

            return root;
        }

        public TreeNode deserialize(String data) {
            String[] data_array = data.split(",");
            List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
            return rdeserialize(data_list);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.remove();
                if (node != null) {
                    result += node.val + ",";
                } else {
                    result += null + ",";
                }

                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;

        String[] values = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        int index = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.remove();
                if (node == null) {
                    continue;
                }

                if ("null".equals(values[index])) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(values[index]));
                }

                index++;

                if ("null".equals(values[index])) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(values[index]));
                }

                index++;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);

        String data = list.toString();
        System.out.println(data);

        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
    }
}
