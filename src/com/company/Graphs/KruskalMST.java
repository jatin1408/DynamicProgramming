package com.company.Graphs;

import java.util.*;

public class KruskalMST {
    int v;
    LinkedList[] adj;
    ArrayList<Edge> arrayList;
    private Map<Integer, Node> map=new HashMap<>();
    static class Node{
        Node parent;
        int data;
        int rank;

        public Node(int data) {
            this.rank=0;
            this.data = data;
        }
    }
    static class Edge {
        int src;
        int des;
        int w;

        public Edge(int src, int des, int w) {
            this.src = src;
            this.des = des;
            this.w = w;
        }


    }

    public KruskalMST(int v) {
        this.v = v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
        arrayList=new ArrayList<>();
    }
    void addEdge(int v,int u,int w){
        adj[v].add(u);
        arrayList.add(new Edge(v,u,w));
    }
    void makeAll(){
        for(int i=0;i<v;i++){
            makeSet(i);
        }
    }
    void makeSet(int data){
        Node n=new Node(data);
        map.put(data,n);
        n.parent=n;
    }
    void union(int data1,int data2){
        Node n1=findSet(map.get(data1));
        Node n2=findSet(map.get(data2));
        if(n1==n2){
            return;
        }
        if(n1.rank>= n2.rank){
            n1.rank=n1.rank==n2.rank?n1.rank+1:n1.rank;
            n2.parent=n1;
        }
        else {
            n2.rank+=1;
            n1.parent=n2;
        }
    }
    Node findSet(Node node){
         Node parent=node.parent;
        if(parent==node){
            return parent;
        }
        node.parent=findSet(node.parent);
        return node.parent;
    }
    public void MST(){
       arrayList.sort(new Comparator<Edge>() {
           @Override
           public int compare(Edge o1, Edge o2) {
               return o1.w- o2.w;
           }
       });
       ArrayList<Edge> res=new ArrayList<>();
       makeAll();
       int count=0;
        for(Edge e:arrayList) {

            if(count==v){
                break;
            }
            Node e1 = findSet(map.get(e.src));
            Node e2 = findSet(map.get(e.des));

            if (e1 != e2) {
                union(e.src, e.des);
                res.add(e);
                count++;
            }

        }
       for(Edge e:res){
           System.out.println(e.src+" "+e.des+" "+e.w);
       }
    }

    public static void main(String[] args) {
        KruskalMST s=new KruskalMST(4);
        s.addEdge(0,1,10);
        s.addEdge(0,2,6);
        s.addEdge(0,3,5);
        s.addEdge(2,3,4);
        s.addEdge(1,3,15);
        s.MST();
    }
}
