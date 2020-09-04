package com.company.Tress;

class Solution {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] pre,int[] in,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode n=new TreeNode(pre[preIndex++]);
        if(start==end){
            return n;
        }
        int inIndex=search(in,start,end,n.val);
        n.left=helper(pre,in,start,inIndex-1);
        n.right=helper(pre,in,inIndex+1,end);
        return n;

    }

    public int search(int[] inorder,int start,int end,int target){
        int i;
        for(i=start;i<=end;i++){
            if(inorder[i]==target){
                return i;
            }
        }
        return i;
    }
}