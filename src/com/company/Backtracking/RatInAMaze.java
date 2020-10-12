package com.company.Backtracking;

public class RatInAMaze {
    int[][] sol;
    int n;
    public RatInAMaze(int n) {
        this.n=n;
        sol=new int[n][n];
    }
    void printSolution(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(sol[i][j]+" ");
            }
        }
        System.out.println();
    }
    void ratInAMazeHelper(int[][] maze,int row,int col,int n){
        if(row>=n || row<0 || col<0 || col>=n || maze[row][col]==0 || sol[row][col]==1){
            return;
        }
        if(row==n-1 && col==n-1){
            sol[row][col]=1;
            printSolution();
            return;
        }
        sol[row][col]=1;
        ratInAMazeHelper(maze,row-1,col,n);
        ratInAMazeHelper(maze,row+1,col,n);
        ratInAMazeHelper(maze,row,col-1,n);
        ratInAMazeHelper(maze,row,col+1,n);
        sol[row][col]=0;
    }

    public static void main(String[] args) {
        RatInAMaze r=new RatInAMaze(4);
        int[][] maze={{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        r.ratInAMazeHelper(maze,0,0,4);
    }
}
