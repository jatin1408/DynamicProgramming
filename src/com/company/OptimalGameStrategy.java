package com.company;

public class OptimalGameStrategy {
    int getMax(int[] arr,int n){
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
                dp[i][i]=arr[i];
                if(i!=n-1){
                    dp[i][i+1]=Math.max(arr[i],arr[i+1]);
                }
        }
        for(int len=2;len<n;len++){
            for(int i=0,j=len;j<n;i++,j++){
                dp[i][j]=Math.max(arr[i]+Math.min(dp[i+2][j],dp[i+1][j]),arr[j]+Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] arr={10,30,5,8};
        OptimalGameStrategy o=new OptimalGameStrategy();
        System.out.println(o.getMax(arr,4));
    }
}
