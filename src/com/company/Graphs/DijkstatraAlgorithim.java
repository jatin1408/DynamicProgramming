package com.company.Graphs;

public class DijkstatraAlgorithim {
    int V;
    boolean[] visited;
    int[] value;
    int[] parent;
    int source;
    public DijkstatraAlgorithim(int v,int source) {
        V=v;
        parent=new int[v];
        value=new int[v];
        visited=new boolean[v];
        this.source=source;
        for(int i=0;i<V;i++){
            parent[i]=-1;
            value[i]=Integer.MAX_VALUE;
        }
        value[source]=0;
    }
    int getMinVertex(boolean[] visited,int[] value){
        int min=Integer.MAX_VALUE;
        int res=-1;
        for(int i=0;i<V;i++){
            if(!visited[i] && value[i]<min){
                res=i;
                min=value[i];
            }
        }
        return res;
    }
    public void shortestPath(int[][] distance){
        for(int i=0;i<V-1;i++){
            int u=getMinVertex(visited,value);
            visited[u]=true;
            for(int j=0;j<V;j++){
                if(distance[u][j]!=0 && !visited[j] && value[u]!=Integer.MAX_VALUE  && (value[u]+distance[u][j]<value[j])){
                    value[j]=value[u]+distance[u][j];
                    parent[j]=u;
                }
            }
        }
        printSolution(distance);
    }
    public void printSolution(int[][] graph){
        for(int i=1;i<V;i++){
            if(i==source){
                continue;
            }
            System.out.println(parent[i]+"<"+i+" "+graph[parent[i]][i]);
        }

    }

    public static void main(String[] args) {
        int V=6;
        int graph[][] = { {0, 1, 4, 0, 0, 0},
                {1, 0, 4, 2, 7, 0},
                {4, 4, 0, 3, 5, 0},
                {0, 2, 3, 0, 4, 6},
                {0, 7, 5, 4, 0, 7},
                {0, 0, 0, 6, 7, 0} };
        graph=new int[][]{{0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0},

        };
        DijkstatraAlgorithim d=new DijkstatraAlgorithim(3,2);
        d.shortestPath(graph);

    }
}
