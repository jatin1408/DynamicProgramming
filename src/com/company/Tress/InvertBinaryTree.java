package com.company.Tress;

public class InvertBinaryTree {

    public class TreeNode{
        int data;
       TreeNode left,right;
        public TreeNode(int data) {
            this.data = data;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
