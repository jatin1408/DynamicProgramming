package com.company.Backtracking;

public class GraphColoringProblem {
    static int V=4;
    int[] color;
    boolean isSafe(int v,int c,int[] color,int[][] graph){
        for(int i=0;i<V;i++)
            if(graph[i][v]==1 && color[i]==c)
                return false;

        return true;
    }
    boolean coloring(int[][] graph,int m,int[] color,int v){
        if(v==V)
            return true;
        for(int c=1;c<=m;c++){
            if(isSafe(v,c,color,graph)){
                color[v]=c;
                if(coloring(graph,m,color,v+1)){
                    return true;
                }
                color[v]=0;
            }
        }
        return false;
    }
   void graphColoring(int[][] graph,int m){
        color=new int[V];
        if(!coloring(graph,m,color,0)){
            System.out.println("Not Possible");
            return ;
        }
        printSolution();

    }
    void printSolution(){
        for(int i=0;i<V;i++){
            System.out.print(color[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphColoringProblem g=new GraphColoringProblem();
        int[][] graph = new int[][]{
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 },
        };
        int m = 3;
        g.graphColoring(graph,m);
    }
}
