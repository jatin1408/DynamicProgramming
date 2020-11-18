package com.company.Graphs;
import java.util.*;
public class BipartiteGraph {
        int V;
        LinkedList<Integer> adj[];
        int[] color;
        public boolean isBipartite(int[][] graph) {
            int n=graph.length;
            V=n;
            adj=new LinkedList[V];

            color=new int[V];
            for(int i=0;i<V;i++){
                adj[i]=new LinkedList<>();
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<graph[i].length;j++){
                    addEdge(i,graph[i][j]);
                }
            }
            Arrays.fill(color,-1);
            for(int i=0;i<n;i++){
                if(color[i]==-1 && !dfs(i)){
                    return false;
                }
            }
            return true;
        }
        public void addEdge(int v,int u){
            adj[v].add(u);
        }
        public boolean dfs(int v){
            Iterator<Integer> i=adj[v].listIterator();
            while(i.hasNext()){
                int temp=i.next();
                if(color[temp]!=-1){
                    if(color[temp]==color[v]){
                        return false;
                    }
                }
                else{

                    color[temp]=1-color[v];
                    if(!dfs(temp)){
                        return false;
                    }
                }
            }
            return true;
        }


    }

