package com.company;

public class CoinChange {
    public static void getCoins(int[] arr,int sum){
        System.out.println(unbound(arr,sum,arr.length));
    }
    public static int unbound(int[] arr,int sum,int n){
        int[][] t=new int[n+1][sum+1];
        for(int i=0;i<n;i++){
            t[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                t[i][j]=t[i-1][j];
                if(arr[i-1]<=j){
                    t[i][j]=t[i][j]+t[i][j-arr[i-1]];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr={1,2,5};
        int sum=5;
        getCoins(arr,sum);
    }
}
