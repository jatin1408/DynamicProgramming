package com.company;

public class ShortestCommonSub {
    public static int SCS(String a,String b){
        int full=a.length()+b.length();
        int lcs=helper(a,b);
        return full-lcs;
    }
    public static int helper(String a,String b){
        int m=a.length();
        int n=b.length();

        int[][] t=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            t[0][i]=0;
            t[i][0]=0;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }
                else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
