package com.company;

public class SubsetDiff {

    public static void numberOfSubsets(int[] arr,int n,int diff){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int target_sum=(diff+sum)/2;

        System.out.println(helper(arr,n,target_sum));
       }
    public static int helper(int[] arr,int n,int sum){
       int[][] t=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            t[i][0]=1;
        }
        for(int i=0;i<=sum;i++){
            t[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                t[i][j]=t[i-1][j];
                if(arr[i-1]<=j){
                    t[i][j]=t[i][j]+t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {

    }
}
