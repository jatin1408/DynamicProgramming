package com.company.Graphs;
import java.util.*;
public class AllTargetToSourcePaths {

        int V;
        LinkedList<Integer> adj[];
        boolean[] visited;
        List<List<Integer>> res=new ArrayList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            int n=graph.length;
            V=n;
            adj=new LinkedList[V];
            visited=new boolean[V];
            for(int i=0;i<V;i++){
                adj[i]=new LinkedList<>();
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<graph[i].length;j++){
                    addEdge(i,graph[i][j]);
                }
            }
            ArrayList<Integer> array=new ArrayList<>();
            dfs(0,n-1,visited,array);
            return res;
        }
        public void addEdge(int v,int u){
            adj[v].add(u);
        }
        public void dfs(int src,int target,boolean[] visited,ArrayList<Integer> arrayList){

            arrayList.add(src);
            if(src==target){
                visited[src]=false;
                res.add(new ArrayList(arrayList));
                arrayList.remove(new Integer(src));
                return;
            }
            Iterator<Integer> i=adj[src].listIterator();
            while(i.hasNext()){
                int temp=i.next();
                if(!visited[temp]){
                    visited[temp]=true;
                    dfs(temp,target,visited,arrayList);
                }
            }
            arrayList.remove(new Integer(src));
            visited[src]=false;
        }
    }
