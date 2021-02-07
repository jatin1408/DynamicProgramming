package com.company.Tress;




public class SumRootToLeafPath {
    static class TreeNode {
        int val;
        TreeNode left;
      TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static int total=0;
    public static void getSum(TreeNode node,StringBuilder sb){
        if(node==null){

            return;
        }
        if(node.left==null && node.right==null){

            sb.insert(0,node.val);
            System.out.println(sb);
            total+= Integer.parseInt(sb.toString());
            sb.deleteCharAt(0);
            return;
        }
        sb.insert(0,node.val);
        getSum(node.left,sb);
        getSum(node.right,sb);
        sb.deleteCharAt(0);
    }
}
