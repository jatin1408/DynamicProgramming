package com.company.Tress;
import  java.util.*;
public class LevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> a = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root == null) {
                return a;
            }
            q.add(root);
            while (!q.isEmpty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                    temp.add(curr.val);
                }
                a.add(new ArrayList(temp));

            }
            return a;
        }
    }
}

