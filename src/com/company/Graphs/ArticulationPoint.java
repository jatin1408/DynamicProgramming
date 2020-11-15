package com.company.Graphs;

import java.util.*;
public class ArticulationPoint {
    private int V;
    private LinkedList<Integer> adj[];
    boolean[] visited;
    public ArticulationPoint(int v) {
        V = v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();

        visited=new boolean[v];
    }

    void addEdge(int v,int u){
        adj[v].add(u);
        adj[u].add(v);
    }
  int time=0;
    public void findArticulationPoint() {
        boolean[] articulation = new boolean[V];
        int[] des = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Arrays.fill(des,-1);
        Arrays.fill(parent,-1);
        for (int i = 0; i < V; i++) {
            if (des[i] == -1) {
                helper(des, low, parent, i, articulation);
            }
        }
        for (int i = 0; i < V; i++) {
            if (articulation[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public void helper(int[] des,int[] low,int[] parent,int curr_vertex,boolean[] articulation){
        des[curr_vertex]=low[curr_vertex]=time++;
        int c=0;
        Iterator<Integer> i=adj[curr_vertex].listIterator();
        while (i.hasNext()){
            int vertex=i.next();
            if(des[vertex]==-1){
                parent[vertex]=curr_vertex;
                c++;
                helper(des,low,parent,vertex,articulation);
                low[curr_vertex]=Math.min(low[curr_vertex],low[vertex]);
                if(parent[curr_vertex]==-1 && c>=2){
                    articulation[curr_vertex]=true;
                }
                if(parent[curr_vertex]!=-1 && low[vertex]>=des[curr_vertex]){
                    articulation[curr_vertex]=true;
                }
            }
            else if(vertex!=parent[curr_vertex]){
                low[curr_vertex]=Math.min(low[curr_vertex],des[vertex]);
            }
        }
    }

    public static void main(String[] args) {
        ArticulationPoint g2=new ArticulationPoint(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.findArticulationPoint();
    }
}
