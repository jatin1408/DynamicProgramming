package com.company.Tress;

public class LargestBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public MinMax largestBST(TreeNode root){
        if(root==null){
            return new MinMax();
        }
        MinMax left=largestBST(root.left);
        MinMax right=largestBST(root.right);
        MinMax m=new MinMax();
        if(!left.isBST || !right.isBST || left.max> root.val || right.min<= root.val){
            m.isBST=false;
            m.size=Math.max(left.size, right.size);
            return m;
        }
        m.isBST=true;
        m.size= left.size+ right.size+1;
        m.min=root.left!=null?left.min: root.val;
        m.max=root.right!=null? right.max : root.val;
        return m;
    }
    public class MinMax{
        int size;
        boolean isBST;
        int max;
        int min;

        public MinMax() {
            isBST=true;
            size=0;
            max=Integer.MAX_VALUE;
            min=Integer.MIN_VALUE;
        }
    }
}
