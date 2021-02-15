package com.company.Tress;


public class CountNoOfBSTs {
    static int total=0;
    public static boolean BSTs(TreeNode root){
        if(root==null) return true;
        boolean left=BSTs(root.left);
        boolean right=BSTs(root.right);
        if(root.left!=null && root.right!=null){
            if(root.val>root.left.val && root.val<root.right.val){
                total+=1;
                return left && right;
            }
            return false;
        }
        if(root.left!=null){
            if(root.val>root.left.val){
                total+=1;
                return left && right;
            }
            return false;
        }
        if(root.right!=null){
            if(root.val>root.right.val) {
                total+=1;
                return left && right;
            }
            return false;
        }
        total+=1;
        return true;
    }
}
