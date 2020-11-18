package com.company.Graphs;
import java.util.*;
public class MinimumHeightTree {

        int V;
        LinkedList<Integer> adj[];
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if(n<2){
                ArrayList<Integer> arrayList=new ArrayList<>();
                for(int i=0;i<n;i++){
                    arrayList.add(i);
                }
                return arrayList;
            }
            V=n;
            adj=new LinkedList[V];
            for(int i=0;i<V;i++){
                adj[i]=new LinkedList<>();
            }
            for(int[] edge:edges){
                addEdge(edge[0],edge[1]);
            }
            ArrayList<Integer> leaves=new ArrayList<>();
            for(int i=0;i<n;i++)
                if(adj[i].size()==1)
                    leaves.add(i);

            int r=n;
            while(r>2){
                r-=leaves.size();
                ArrayList<Integer> newLeaves=new ArrayList<>();
                for(Integer leaf:leaves){
                    Iterator<Integer> i=adj[leaf].listIterator();
                    while(i.hasNext()){
                        int temp=i.next();
                        adj[temp].remove(leaf);
                        if(adj[temp].size()==1){
                            newLeaves.add(temp);
                        }
                    }
                    leaves=newLeaves;
                }
            }

            return leaves;
        }
        public void addEdge(int v,int u){
            adj[v].add(u);
            adj[u].add(v);
        }
    }

