package com.company;

public class MaximumRectangle {

        public int maximalRectangle(char[][] matrix) {
            int rows=matrix.length;
            if(rows==0) return 0;
            int cols=matrix[0].length;
            int[][] dp=new int[rows][cols];
            int maxarea=0;
            for(int i=0;i<rows;i++)
                for(int j=0;j<cols;j++){
                    int no=Character.getNumericValue(matrix[i][j]);

                    if(i==0) dp[i][j]=no==0?0:1;
                    else
                        dp[i][j]=no==0?0:dp[i-1][j]+1;
                    int min=dp[i][j];
                    for(int k=j;k>=0;k--){
                        if(dp[i][k]==0)  break;
                        if(dp[i][k]<min) min=dp[i][k];
                        maxarea=Math.max(maxarea,min*(j-k+1));
                    }
                }
            return maxarea;
        }

}
