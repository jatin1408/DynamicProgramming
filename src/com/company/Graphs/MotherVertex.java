package com.company.Graphs;
import java.util.*;
public class MotherVertex {
    private int V;
    private LinkedList<Integer> adj[];
    boolean[] visited;
    public MotherVertex(int v) {
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
    public void dfsUtil(int vertex, boolean[] visited, Stack<Integer> stack){
        visited[vertex]=true;
        Iterator<Integer> i=adj[vertex].listIterator();
        while (i.hasNext()){
            int temp=i.next();
            if(!visited[temp]){
                dfsUtil(temp,visited,stack);
            }
        }
        stack.push(vertex);
    }
    public int motherVertex(){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++) {
            if(!visited[i])
            dfsUtil(i, visited, stack);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){

                return -1;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        MotherVertex g=new MotherVertex(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(4,1);
        g.addEdge(6,4);
        g.addEdge(5,6);
        g.addEdge(5,2);
        g.addEdge(6,0);
        System.out.println(g.motherVertex());

    }
}
