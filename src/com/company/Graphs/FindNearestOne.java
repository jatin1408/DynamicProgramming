package com.company.Graphs;

import java.util.LinkedList;
import java.util.Queue;
//https://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix/
public class FindNearestOne {
    class Node{
        int x;
        int y;
        int d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public void findNearest(int[][] binary){
        Queue<Node> queue=new LinkedList<>();
        int rows=binary.length;
        int cols=binary[0].length;
        int[][] matrix=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(binary[i][j]==1){
                    queue.add(new Node(i,j,0));
                }
            }
        }
        boolean[][] visited=new boolean[rows][cols];
        while (!queue.isEmpty()){
            Node n=queue.remove();
            matrix[n.x][n.y]=n.d;
            boolean a1=isValid(n.x+1,n.y,rows, cols);
            boolean a2=isValid(n.x-1,n.y,rows, cols);
            boolean a3=isValid(n.x,n.y-1,rows, cols);
            boolean a4=isValid(n.x,n.y+1,rows, cols);
            if(a1 && binary[n.x+1][n.y]!=1 && !visited[n.x+1][n.y]){
                visited[n.x+1][n.y]=true;
                queue.add(new Node(n.x+1,n.y,n.d+1));
            }
            if(a2 && binary[n.x-1][n.y]!=1 && !visited[n.x-1][n.y]){
                visited[n.x-1][n.y]=true;
                queue.add(new Node(n.x-1,n.y,n.d+1));
            }
            if(a3 && binary[n.x][n.y-1]!=1 && !visited[n.x][n.y-1]){
                visited[n.x][n.y-1]=true;
                queue.add(new Node(n.x,n.y-1,n.d+1));
            }
            if(a4 && binary[n.x][n.y+1]!=1 && !visited[n.x][n.y+1]) {
                visited[n.x][n.y+1]=true;
                queue.add(new Node(n.x, n.y + 1, n.d + 1));
            }

        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    public boolean isValid(int i,int j,int rows,int cols){
        if(i>=rows || j>=cols || i<0 || j<0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        FindNearestOne f=new FindNearestOne();
        int[][] mat = {{ 0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0 }};
        f.findNearest(mat);
    }

}
