package com.company.Graphs;

import java.util.HashMap;

public class DisjointSets {
        HashMap<Integer,Node> hashMap=new HashMap<>();
    static class Node{
        Node parent;
        int data;
        int rank;

        public Node(int data) {
            this.data = data;
            this.rank=0;
        }
    }
    public void makeSet(int data){
        Node n=new Node(data);
        n.parent=n;
        hashMap.put(data,n);
    }
    public Node findParent(Node node){
        Node parent=node.parent;
        if(parent==node){
            return parent;
        }
        node.parent=findParent(node.parent);
        return node.parent;
    }
    public void union(int data1,int data2){
        Node n1=hashMap.get(data1);
        Node n2=hashMap.get(data2);
        Node p1=findParent(n1);
        Node p2=findParent(n2);
        if(p1==p2){
            return;
        }
        if(p1.rank>=p2.rank){
            p1.rank=p1.rank==p2.rank? p1.rank+1 : p1.rank;
            p2.parent=p1;
        }
        else {
            p1.parent=p2;
        }
    }
    public int findSet(int data){
        return findParent(hashMap.get(data)).data;
    }

    public static void main(String[] args) {
        DisjointSets ds = new DisjointSets();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
