package com.company.Tress;

public class SmallestSubTreeWithDeepestNode {

        int maxDepth=0;
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            maxDepth=maxDepth(root);
            return dfs(root,1);
        }
        public int maxDepth(TreeNode root){
            if(root==null) return 0;
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return Math.max(left,right)+1;
        }
        public TreeNode dfs(TreeNode node,int level){
            if(node==null) return null;
            if(level==maxDepth) return node;
            TreeNode left=dfs(node.left,level+1);
            TreeNode right=dfs(node.right,level+1);
            if(left!=null && right!=null) return node;
            if(left!=null) return left;
            if(right!=null) return right;
            return null;
        }
    }

