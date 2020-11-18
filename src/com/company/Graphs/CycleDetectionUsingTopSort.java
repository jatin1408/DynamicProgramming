package com.company.Graphs;
import java.util.*;
//https://leetcode.com/problems/course-schedule-ii
public class CycleDetectionUsingTopSort {
    LinkedList<Integer> adj[];
    int V;
    public int[] findOrder(int numCourses, int[][] p) {
        V=numCourses;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<p.length;i++){
            addEdge(p[i][1],p[i][0]);
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,stack);
            }
        }
        int[] res=new int[V];
        int i=0;
        //Cycle Detection Part Start here
        HashMap<Integer,Integer> map=new HashMap<>();
        while(!stack.isEmpty()){
            map.put(stack.peek(),i);
            res[i]=stack.peek();
            i++;
            stack.pop();
        }
        for(i=0;i<V;i++){
            Iterator<Integer> it=adj[i].listIterator();
            while(it.hasNext()){
                int temp=it.next();
                if(map.get(temp)<map.get(i)){
                    return new int[0];
                }
            }
        }
        return res;
    }
    public void addEdge(int v,int u){
        adj[v].add(u);
    }
    public void dfs(int v,boolean[] visited,Stack<Integer> stack){
        visited[v]=true;
        Iterator<Integer> i=adj[v].listIterator();
        while(i.hasNext()){
            int temp=i.next();
            if(!visited[temp]){
                dfs(temp,visited,stack);
            }
        }
        stack.push(v);
    }
}
