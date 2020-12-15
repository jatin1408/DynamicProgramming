package com.company.Tress;
import java.util.*;

public class RightSideView {
    public class TreeNode{
        int val;
        TreeNode left;
       TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    class Tree{
        ArrayList<Integer> rightView(TreeNode root) {
            //add code here.
            ArrayList<Integer> a=new ArrayList<Integer>();
            if(root==null)
                return a;
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    TreeNode u=q.poll();
                    if(i==0) a.add(u.val);
                    if(u.right!=null) q.add(u.right);
                    if(u.left!=null) q.add(u.left);
                }
            }
            return a;
        }
    }
}
