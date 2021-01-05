package com.company.Tress;

public class TreefromLevelAndInorder {
    static class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode create(int[] level,int[] in,int n){
        TreeNode t=null;
        return createTree(t,level,in,0,n-1,n);


    }
    public TreeNode createTree(TreeNode node,int[] level,int[] in,int left,int right,int n){
        if(left>right){
            return null;
        }
        if(left==right){
            return new TreeNode(in[left]);
        }
        boolean found=false;
        int index=0;
        for(int i=0;i<n;i++){
            int target=level[i];
            for(int j=left;j<right;j++){
                if(target==in[j]){
                    node=new TreeNode(target);
                    index=j;
                    found=true;
                    break;
                }

            }
            if(found){
                break;
            }
        }
        node.left=createTree(node,level,in,left,index-1,n);
        node.right=createTree(node,level,in,index+1,right,n);
        return node;
    }
    public void checkTree(TreeNode root){

        if(root==null)
            return;
        System.out.print(root.val+" ");
        checkTree(root.left);
        checkTree(root.right);
    }

    public static void main(String[] args) {
        TreefromLevelAndInorder t=new TreefromLevelAndInorder();
        int[] level={20,8,22,4,12,10,14};
        int[] inOrder={4,8,10,12,14,20,22};
        t.checkTree(t.create(level,inOrder,level.length));
    }
}
