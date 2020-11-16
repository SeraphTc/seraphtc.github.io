package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            sb.append(",").append(treeNode.left == null ? "#" : treeNode.left.val);
            sb.append(",").append(treeNode.right == null ? "#" : treeNode.right.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }

        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        if (data == "#") {
            return null;
        }
        String[] subs = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode result = new TreeNode(Integer.parseInt(subs[0]));
        queue.add(result);
        for (int i = 1; i < subs.length; i++) {
            TreeNode root = queue.poll();
            if (!subs[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(subs[i]));
                root.left = left;
                queue.add(left);
            }
            if (!subs[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(subs[i]));
                root.right = right;
                queue.add(right);
            }
        }
        return result;
    }


    public String serializeDFS(TreeNode root) {
        if (root == null) {
            return "#";
        }

        return root.val + "," + serializeDFS(root.left) + "," + serializeDFS(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeDFS(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode result = new TreeNode(Integer.parseInt(val));
        result.left = dfs(queue);
        result.right = dfs(queue);
        return result;
    }


    public static void main(String[] args) {
        SerializeTree s = new SerializeTree();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;
        String result = s.serializeDFS(root1);
        TreeNode root = s.deserializeDFS(result);
        System.out.println(root);

    }
}