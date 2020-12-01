package com.company.Tress;

public class TreeFromInorder {
    TreeNode root;
    static int index=0;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode createTree(int[] preOrder,int[] inOrder,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode n=new TreeNode(preOrder[index++]);
        if(start==end){
            return n;
        }
        int breakPoint=searchArr(start,end,preOrder,inOrder,n.val);
        n.left=createTree(preOrder,inOrder,start,breakPoint-1);
        n.right=createTree(preOrder,inOrder,breakPoint+1,end);
        return n;
    }
    public int searchArr(int start,int end,int[] preOrder,int[] inOrder,int target){
        for(int i=start;i<=end;i++){
            if(inOrder[i]==target){
                return i;
            }
        }
        return end;
    }


}
