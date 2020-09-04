package com.company.Tress;
public class inOrderSucc {
    TreeNode root;
    public class TreeNode{
        int data;
        TreeNode left,right;
        public TreeNode(int data) {
            this.data = data;
        }
    }
    public TreeNode findInorder(TreeNode node){
        if(node.right!=null){
            return findFromRoot(node);

        }return findMin(node);
    }
    public TreeNode findMin(TreeNode node){
        TreeNode curr=node;
        while (curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }
    public TreeNode findFromRoot(TreeNode node){
        TreeNode temp=root;
        TreeNode succ=null;
        while (temp!=null){
            if(temp.data>node.data){
                succ=temp;
                temp=temp.left;
            }
            else if (node.data< temp.data){
                temp=temp.right;
            }
            else {
                break;
            }
        }
        return succ;
    }
}
