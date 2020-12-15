package com.company.Backtracking;

import java.util.Arrays;

public class HamiltonianCycle {
    final int V=5;
    int[] path;
    boolean cycleExists(int[][] graph,int[] path,int pos) {
        if (pos == V) {
        if(graph[path[pos-1]][path[0]]==1)
                return true;
            return false;
        }
        for(int i=1;i<V;i++){
            if(isSafe(pos,path,graph,i)){
                path[pos]=i;
                if(cycleExists(graph,path,pos+1)==true)
                    return true;
                path[pos]=-1;
            }
        }
        return false;
    }
    boolean isSafe(int pos,int[] path,int[][] graph,int vertex){
        if(graph[path[pos-1]][vertex]==0)
            return false;
        for(int i=0;i<pos;i++)
            if(path[i]==vertex)
                return false;


        return true;
    }

    boolean hamCycle(int[][] graph){
        path=new int[V];
        Arrays.fill(path,-1);
        path[0]=0;
         if(cycleExists(graph,path,1)==false)
             return false;
         print(path);
         return true;
    }
    void print(int[] path){
        for(int i=0;i<V;i++){
            System.out.print(path[i]+" ");
        }
        System.out.println(path[0]);
    }

    public static void main(String[] args) {
        HamiltonianCycle h=new HamiltonianCycle();
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        if(h.hamCycle(graph1)==false)
            System.out.println("Not possible");
    }
}
