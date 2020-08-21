package com.company;

public class ChilderSum {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
        }
    }
    class BinaryTree{
        Node root;
        void convertTree(Node root){
            int left_data=0,right_data=0,diff;
            if(root==null || (root.left!=null && root.right!=null)){
                return;
            }
            convertTree(root.left);
            convertTree(root.right);
            if(root.left!=null){
                left_data=root.left.data;
            }
            if(root.right!=null){
                right_data=root.right.data;
            }
            diff=left_data+right_data-root.data;
            if(diff>0){
                root.data+=diff;
            }
            if(diff<0){
                increment(root,-diff);
            }
        }
        void increment(Node root,int diff){
            if(root.left!=null){
                root.left.data+=diff;
                increment(root.left,diff);
            }
            else if(root.right!=null){
                root.right.data+=diff;
                increment(root.right,diff);
            }
        }
    }
}
