package com.company.Graphs;
import java.util.*;
public class TopologicalSorting {
    private int V;
    private LinkedList<Integer> adj[];
    boolean[] visited;
    public TopologicalSorting(int v) {
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
    void topologicalSort(int vertex, Stack<Integer> stack){
        visited[vertex]=true;
        Iterator<Integer> i=adj[vertex].listIterator();
        while (i.hasNext()){
            int temp=i.next();
            if(!visited[temp]){
                topologicalSort(temp,stack);
            }
        }
        stack.push(vertex);
    }
    void topSort(){
        Arrays.fill(visited,false);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topologicalSort(i,stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TopologicalSorting g=new TopologicalSorting(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topSort();
    }
}
