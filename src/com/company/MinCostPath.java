package com.company;

public class MinCostPath {
    int minCostPath(int[][] arr,int m,int n){
       int[][] t=new int[m][n];
       t[0][0]=arr[0][0];
       for(int i=1;i<m;i++){
           t[i][0]=t[i-1][0]+arr[i][0];
       }
        for(int i=1;i<n;i++){
            t[0][i]=t[0][i-1]+arr[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                t[i][j]=arr[i][j]+Math.min(t[i-1][j],t[i][j-1]);
            }
        }
        return t[m-1][n-1];
    }

    public static void main(String[] args) {
        MinCostPath minCostPath=new MinCostPath();
        int[][] arr={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minCostPath.minCostPath(arr, arr.length, arr[0].length));
    }
}
