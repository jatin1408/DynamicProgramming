package com.company;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] t=new int[height][width];
        return min(grid, height - 1, width - 1,t);

    }

    public  int min(int[][]grid, int row, int col,int[][] t){
        if(t[row][col]!=0){
            return t[row][col];
        }
        if(row == 0 && col == 0) return t[row][col]=grid[row][col]; // this is the exit of the recursion
        if(row == 0) return t[row][col]=grid[row][col] + min(grid, row, col - 1,t); /** when we reach the first row, we could only move horizontally.*/
        if(col == 0) return t[row][col]=grid[row][col] + min(grid, row - 1, col,t); /** when we reach the first column, we could only move vertically.*/
        return t[row][col]=grid[row][col] + Math.min(min(grid, row - 1, col,t), min(grid, row, col - 1,t)); /** we want the min sum path so we pick the cell with the less value */

    }
}
