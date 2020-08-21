package com.company;

public class MaximumPathSum {
    Node root;
    static class Res{
        int val;
    }
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
        }
    }
    int  maximumPathSum(Node root,Res res){
        if(root==null){
            return 0;
        }
        int l=maximumPathSum(root.left,res);
        int r=maximumPathSum(root.right,res);
        int maxSingle=Math.max(Math.max(l,r)+ root.data,root.data);
        int maxCombined=Math.max(maxSingle,l+r+root.data);
        res.val=Math.max(maxSingle,maxCombined);
        return maxSingle;
    }
    int findMaxSum(){
        return findMaxSum(root);
    }
    int findMaxSum(Node node) {


        Res res = new Res();
        res.val = Integer.MIN_VALUE;


        maximumPathSum(node, res);
        return res.val;
    }

    public static void main(String[] args) {
        MaximumPathSum tree=new MaximumPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println(tree.findMaxSum());
    }
}
