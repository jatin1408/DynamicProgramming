package com.company.Tress;

public class SubTreeOfOther {
    public class TreeNode{
        int val;
     TreeNode left;
 TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    class Solution {

        public boolean isSubtree(TreeNode s, TreeNode t) {
            return traverse(s,t);
        }
        public boolean equals(TreeNode s,TreeNode t){
            if(s==null && t==null)
                return true;
            if(s==null || t==null)
                return false;
            return s.val==t.val && equals(s.left,t.left) && equals(s.right,t.right);
        }
        public boolean traverse(TreeNode s,TreeNode t){
            return s!=null && (equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
        }
    }
}
