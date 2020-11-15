package com.company.Graphs;
import java.util.*;


public class StronglyConnectedComponent {
    int V;
    LinkedList<Integer> linkedList[];
    boolean[] visited;
    public StronglyConnectedComponent(int v) {
        V = v;
        linkedList=new LinkedList[v];
        visited=new boolean[v];
        for(int i=0;i<v;i++){
            linkedList[i]=new LinkedList<>();
            visited[i]=false;
        }
    }
    public void addEdge(int v,int u){
        linkedList[v].add(u);
    }
    public void addUndirected(int v,int u){
        linkedList[v].add(u);
        linkedList[u].add(v);
    }
    public StronglyConnectedComponent transposeGraph(){
        StronglyConnectedComponent s=new StronglyConnectedComponent(V);
        for(int j=0;j<V;j++){
            Iterator<Integer> i=linkedList[j].listIterator();
            while (i.hasNext()){
                s.addEdge(i.next(),j);
            }
        }
        return s;
    }
    public void dfsUtil(int vertex,Stack<Integer> stack,boolean[] visited){
        Iterator<Integer> i=linkedList[vertex].listIterator();
        visited[vertex]=true;
        while (i.hasNext()){
            int temp=i.next();
            if(!visited[temp]){
                dfsUtil(temp,stack,visited);
            }
        }
        stack.push(vertex);
    }
    public void dfsUtil(int vertex,boolean[] visited){
        Iterator<Integer> i=linkedList[vertex].listIterator();
        visited[vertex]=true;
        System.out.print(vertex+" ");
        while (i.hasNext()){
            int temp=i.next();
            if(!visited[temp]){
                dfsUtil(temp,visited);
            }
        }
    }
    public void stronglyConnected(){
        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++) {
            if (!visited[i]) {

                dfsUtil(i, stack, visited);
            }
        }
        Arrays.fill(visited,false);
        StronglyConnectedComponent s=transposeGraph();
        while (!stack.isEmpty()){

            int popped=stack.pop();
            if(!visited[popped]){
               s.dfsUtil(popped,visited);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        StronglyConnectedComponent g = new StronglyConnectedComponent(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.stronglyConnected();

    }

}
