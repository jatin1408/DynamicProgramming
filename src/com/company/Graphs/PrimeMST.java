package com.company.Graphs;

import java.util.Arrays;

public class PrimeMST {
    static int V=5;

    int findMin(int[] dist,boolean[] visited){
        int res=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<V;i++){
            if( !visited[i] && dist[i]<res ){
                res=dist[i];
                index=i;
            }
        }
        return index;
    }
    void MST(int[][] graph,int source){
        int[] dist=new int[V];
        boolean[] visited=new boolean[V];
        int[] parent=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        parent[source]=-1;
        for(int i=0;i<V-1;i++){
            int u=findMin(dist,visited);

            visited[u]=true;
            for(int j=0;j<V;j++){
                if(graph[u][j]!=0 && !visited[j] && dist[j]>graph[u][j]){
                    parent[j]=u;
                    dist[j]=graph[u][j];
                }
            }
        }
        printGraph(parent,graph);
    }
    void printGraph(int[] parent,int[][] graph){
            for(int i=1;i<V;i++){
                System.out.println(parent[i]+" - "+i+" "+graph[i][parent[i]]);
            }
    }

    public static void main(String[] args) {
        PrimeMST p=new PrimeMST();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        p.MST(graph,0);

    }
}
