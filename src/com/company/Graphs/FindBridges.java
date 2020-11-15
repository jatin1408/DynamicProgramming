package com.company.Graphs;
import java.util.*;
public class FindBridges {

        private int V;
        private LinkedList<Integer> adj[];

        void addEdge(int v,int u){
            adj[v].add(u);
            adj[u].add(v);
        }
        int time=0;
        public List<List<Integer>> findBridges() {
            List<List<Integer>> res=new ArrayList<>();
            int[] des = new int[V];
            int[] low = new int[V];
            int[] parent = new int[V];
            Arrays.fill(des,-1);
            Arrays.fill(parent,-1);
            for (int i = 0; i < V; i++) {
                if (des[i] == -1) {
                    helper(des, low, parent, i,res);
                }
            }
            return res;
        }
        public void helper(int[] des,int[] low,int[] parent,int curr_vertex,List<List<Integer>> list) {
            des[curr_vertex] = low[curr_vertex] = time++;

            Iterator<Integer> i = adj[curr_vertex].listIterator();
            while (i.hasNext()) {
                int vertex = i.next();
                if (des[vertex] == -1) {
                    parent[vertex] = curr_vertex;

                    helper(des, low, parent, vertex, list);
                    low[curr_vertex] = Math.min(low[curr_vertex], low[vertex]);

                    if ( low[vertex] > des[curr_vertex]) {

                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(curr_vertex);
                        arrayList.add(vertex);
                        list.add(arrayList);
                    }
                } else if (vertex != parent[curr_vertex]) {
                    low[curr_vertex] = Math.min(low[curr_vertex], des[vertex]);
                }
            }
        }
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

            V = n;
            adj=new LinkedList[n];
            for(int i=0;i<n;i++)
                adj[i]=new LinkedList<>();
            for(int i=0;i<connections.size();i++){
                addEdge(connections.get(i).get(0),connections.get(i).get(1));
            }
            return findBridges();
        }
    }

