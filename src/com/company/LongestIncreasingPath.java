package com.company;

public class LongestIncreasingPath {

        public int longestIncreasingPath(int[][] matrix) {

            int rows=matrix.length;
            if(rows==0) return 0;
            int cols=matrix[0].length;
            int max=1;
            int[][] dp=new int[rows][cols];


            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    int len=dfs(matrix,dp,i,j,rows,cols);
                    max=Math.max(max,len);
                }
            }

            return max;

        }
        public int dfs(int[][] matrix,int[][] dp,int i,int j,int rows,int cols){


            if(dp[i][j]!=0)

                return dp[i][j];


            int up,down,left,right;
            int ans=1;
            if(j<cols-1 && matrix[i][j]<matrix[i][j+1]) {


                right = 1 + dfs(matrix, dp, i, j + 1, rows, cols);
                ans=Math.max(right,ans);
            }
            if(j>0 && matrix[i][j]<matrix[i][j-1]){


                left=1+dfs(matrix,dp,i,j-1,rows,cols);
                ans=Math.max(left,ans);}
            if(i<rows-1 && matrix[i][j]<matrix[i+1][j]){

                down=1+dfs(matrix,dp,i+1,j,rows,cols);
                ans=Math.max(down,ans);
            }
            if(i>0 && matrix[i][j]<matrix[i-1][j]){
                up=1+dfs(matrix,dp,i-1,j,rows,cols);
                ans=Math.max(up,ans);
            }
            return dp[i][j]=ans;
        }
    }

