package com.company.Graphs;
import java.util.*;
public class GraphTraversal {
    private int V;
    private LinkedList<Integer> adj[];
    boolean[] visited;
    public GraphTraversal(int v) {
        V = v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();

        visited=new boolean[v];
    }
    void addEdge(int v,int u){
        adj[v].add(u);
    }
    void addUnDirectedEdge(int v,int u){
        adj[v].add(u);
        adj[u].add(v);
    }
    void dfsUtil(int v,boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        Iterator<Integer> i=adj[v].listIterator();
        while (i.hasNext()){
            v=i.next();
            if(!visited[v])
                dfsUtil(v,visited);

        }
    }
    void dfs(int vertex){
        Arrays.fill(visited,false);
        dfsUtil(vertex,visited);
    }
    void bfsUtil(int v,boolean[] visited){
        Arrays.fill(visited,false);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()){
            int curr=queue.poll();
            System.out.print(curr+" ");
            visited[curr]=true;
            Iterator<Integer> iterator=adj[curr].listIterator();
            while (iterator.hasNext()){
                int next=iterator.next();
                if(!visited[next])
                    queue.add(next);

            }
        }
    }
    void bfs(int vertex){
        bfsUtil(vertex,visited);
    }
    void dfsDisconnected(){
        for(int i=0;i<V;i++)
            if(!visited[i])
                dfs(i);

    }
    public static void main(String[] args) {
        GraphTraversal g=new GraphTraversal(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        //For creating disconnected graph
        g.addEdge(4,4);
        g.dfs(2);
        g.dfsDisconnected();
        System.out.println();
        g.bfs(2);
    }
}
