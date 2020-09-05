package com.company.Tress;

public class MaxPathSumFromLeaf {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(inOrderSucc.TreeNode root){
        if(root==null) return 0;
        int l= maxPathSum(root.left);
        int r=maxPathSum(root.right);
        int f1=Math.max(root.data, root.data+Math.max(l,r));
        int f2=Math.max(f1, root.data+l+r);
        res=Math.max(res,f2);
        return f1;
    }

}
