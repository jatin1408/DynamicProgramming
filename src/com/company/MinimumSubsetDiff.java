package com.company;

public class MinimumSubsetDiff {
    public static int findMin(int[] arr,int n){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        boolean[][] t=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            t[i][0]=true;
        }
        for(int i=0;i<=sum;i++){
            t[0][i]=false;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                t[i][j]=t[i-1][j];
                if(arr[i-1]<=j){
                    t[i][j]=t[i][j]||t[i-1][j-arr[i-1]];
                }
            }
        }
        int min=Integer.MIN_VALUE;
        for(int j=sum/2;j>=0;j--){
            if(t[n][j]==true){
                min=sum-2*j;
                break;
            }
        }
        return min;
    }
    public static void main(String[] args){
        int[] a={3, 1, 4, 2, 2, 1};
        int n=a.length;
        System.out.println(findMin(a,n));
    }
}

