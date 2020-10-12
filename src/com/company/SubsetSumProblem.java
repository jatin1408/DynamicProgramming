package com.company;

public class SubsetSumProblem {
    boolean subsetSum(int[] arr,int n,int sum){
        boolean[][] t=new boolean[n+1][sum+1];
        t[0][0]=true;
        for(int i=1;i<=sum;i++)
            t[0][i]=false;
        for(int i=1;i<=n;i++)
            t[i][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                t[i][j]=t[i-1][j];
                if(arr[i-1]<=j){
                    t[i][j]=t[i][j]||t[i-1][j-arr[i-1]];
                }

            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        SubsetSumProblem s=new SubsetSumProblem();
        int[] arr={3,4,5,2};
        System.out.println(s.subsetSum(arr,arr.length,6));
    }
}
