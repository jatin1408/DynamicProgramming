package com.company.Tress;

public class DeleteANodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key>root.val)
            root.right=deleteNode(root.right,key);

        else if(key<root.val)
            root.left=deleteNode(root.left,key);
        else{
            if(root.left!=null && root.right!=null){
                int max=leftMax(root.left);
                root.val=max;
                root.left=deleteNode(root.left,max);
                return root;
            }
            else if(root.left!=null) return root.left;
            else if(root.right!=null) return root.right;
            else
                return null;

        }
        return root;
    }

    public int leftMax(TreeNode node){
        int max=node.val;
        while(node.right!=null){
            max=node.right.val;
            node=node.right;
        }
        return max;
    }
}

