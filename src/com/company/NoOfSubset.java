package com.company;

public class NoOfSubset {
    public static int noOfWays(int[] arr,int sum,int n){
        int[][] t=new int[n+1][sum+1];

        for(int i=0;i<n;i++){
            t[i][0]=1;
        }
        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++){
                t[i][j]=t[i-1][j];
                if(arr[i-1]<=j)
                    t[i][j]=t[i-1][j]+t[i-1][j-arr[i-1]];

            }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,1};
        int sum=1;
        System.out.println(noOfWays(arr,sum,arr.length));

    }
}
