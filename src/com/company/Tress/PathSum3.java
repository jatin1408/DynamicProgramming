package com.company.Tress;
import java.util.HashMap;
public class PathSum3 {
    public class TreeNode{
        int val;
       TreeNode left,right;
        public TreeNode(int data) {
            this.val = data;
        }
    }
    class Solution {
        int total=0;
        public int pathSum(TreeNode root, int sum) {
            if(root==null){
                return total;
            }
            HashMap<Integer,Integer> hash=new HashMap<>();
            hash.put(0,1);
            find(root,0,sum,hash);
            return total;
        }
        public void find(TreeNode root,int curr,int sum,HashMap<Integer,Integer> hash){
            if(root==null){
                return;
            }
            curr+=root.val;
            if(hash.containsKey(curr-sum)){
                total+=hash.get(curr-sum);
            }
            hash.put(curr,hash.getOrDefault(curr,0)+1);
            find(root.left,curr,sum,hash);
            find(root.right,curr,sum,hash);
            hash.put(curr,hash.get(curr)-1);
        }
    }
}
