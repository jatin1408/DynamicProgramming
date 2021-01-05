package com.company.Tress;
import java.util.*;
public class HouseRobber3 {
    public class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    class Solution {
        public int rob(TreeNode root) {
            HashMap<TreeNode,Integer> mp=new HashMap<>();
            return sum(root,mp);
        }
        public int getSum(TreeNode node,HashMap<TreeNode,Integer> hashmap){
            int s=0;
            if(node.left!=null){
                s+=sum(node.left.left,hashmap)+sum(node.left.right,hashmap);
            }
            if(node.right!=null){
                s+=sum(node.right.left,hashmap)+sum(node.right.right,hashmap);
            }
            return s;
        }
        public int sum(TreeNode node,HashMap<TreeNode,Integer> hashmap){
            if(node==null){
                return 0;
            }

            if(hashmap.containsKey(node)){
                return hashmap.get(node);
            }
            int grandSum=node.val+getSum(node,hashmap);
            int childSum=sum(node.left,hashmap)+sum(node.right,hashmap);
            hashmap.put(node,Math.max(grandSum,childSum));
            return hashmap.get(node);

        }
    }
}
