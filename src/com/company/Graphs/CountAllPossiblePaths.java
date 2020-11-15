package com.company.Graphs;

import java.util.*;

//https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
public class CountAllPossiblePaths {
    private int V;
    private LinkedList<Integer> adj[];
    boolean[] visited;
    int count;
    public CountAllPossiblePaths(int v) {
        V = v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();

        visited=new boolean[v];
        count=0;
    }
    void addEdge(int v,int u){
        adj[v].add(u);
    }
    void addUnDirectedEdge(int v,int u){
        adj[v].add(u);
        adj[u].add(v);
    }
    public void dfsUtil(int start,int target,boolean[] visited){
        visited[start]=true;
        if(start==target) {
            count++;
            return;
        }
        Iterator<Integer> i=adj[start].listIterator();
        while (i.hasNext()){
            int temp=i.next();
            dfsUtil(temp,target,visited);
        }
    }

    public static void main(String[] args) {
        CountAllPossiblePaths g=new CountAllPossiblePaths(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.dfsUtil(0,3, g.visited);
        System.out.println(g.count);

    }
}
