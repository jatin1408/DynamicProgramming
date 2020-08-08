package com.company;

public class MinCoins {
    public int minNumberCoins(int[] arr,int n,int sum){
        int[][] t=new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                t[i][j]=Integer.MAX_VALUE-1;
            }
        }
        for(int i=1;i<n+1;i++){
            t[i][0]=0;
        }
       for(int i=1;i<sum+1;i++){
           if(i%arr[0]==0){
               t[1][i]=i/arr[0];
           }
       }
       for(int i=2;i<n+1;i++){
           for(int j=1;j<sum+1;j++){
               t[i][j]=t[i-1][j];
               if(arr[i-1]<=j){
                t[i][j]=Math.min(t[i][j-arr[i-1]]+1,t[i-1][j]);
               }
           }
       }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        return t[n][sum];
    }
    public static void main(String[] args) {
        int coins[] = {1,2};
        int n=coins.length;
        int sum=2;
        MinCoins m=new MinCoins();
        System.out.println(m.minNumberCoins(coins,n,sum));
    }
}
