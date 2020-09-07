package com.company.Tress;

import java.util.ArrayList;
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;

    }
}
class BinaryTree{
    Node root;
    Node head;
    ArrayList<Node> arrayList=new ArrayList<>();

    public void getInorder(Node root){
        if(root==null){
            return;
        }
        getInorder(root.left);
        arrayList.add(root);
        getInorder(root.right);

    }

    public void makeDoubly(){
        head=arrayList.get(0);
        Node last=head;
        last.right=arrayList.get(1);
        last=arrayList.get(1);
        for(int i=1;i<=arrayList.size()-2;i++){
            last.right=arrayList.get(i+1);
            last.left=arrayList.get(i-1);
            last=arrayList.get(i+1);

        }
        Node temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.right;

        }
        System.out.println();
        System.out.println(head.right.right.left.data);
    }


    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(3);

        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);
       tree.getInorder(tree.root);
       tree.makeDoubly();

    }
}