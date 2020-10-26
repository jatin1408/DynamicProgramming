package com.company;

public class NumberOfIslands {
    int numberOFIslands(char[][] matrix){
        int ans=0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    mark(matrix,rows,cols,i,j);
                   ans++;
                }
            }
        }
        return ans;
    }
    void mark(char[][] matrix,int rows,int cols,int i,int j){
        if(j>=cols || i>=rows || i<0 || j<0 || matrix[i][j]!='1'){
            return;
        }
        matrix[i][j]='2';
        mark(matrix,rows,cols,i+1,j);
        mark(matrix,rows,cols,i-1,j);
        mark(matrix,rows,cols,i,j+1);
        mark(matrix,rows,cols,i,j-1);
    }
    public static void main(String[] args) {

    }
}
