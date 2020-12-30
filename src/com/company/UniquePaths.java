package com.company;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] t=new int[m+1][n+1];
        return count(1,1,m,n,t);
    }


    public  int count(int a,int b,int m,int n,int[][] t){
        if(a==m && b==n){

            return 1;
        }
        if(a>m || b>n){
            return 0;
        }
        if(t[a][b]!=0){
            return t[a][b];
        }

        return  t[a][b]=count(a,b+1,m,n,t)+count(a+1,b,m,n,t);
    }
}
