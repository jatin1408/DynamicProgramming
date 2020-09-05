package com.company;

import java.util.Arrays;

public class MCM {
    public int recursive(int[] arr,int i,int j){
        if(i>=j){
            return 0;
        }
        int MIN=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp=recursive(arr,i,k)+recursive(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            MIN=Math.min(MIN,temp);
        }
        return MIN;
    }
    public int memoize(int[] arr,int[][] t,int i,int j){
        if(i>=j){
            return 0;
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int MIN=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp=memoize(arr,t,i,k)+memoize(arr,t,k+1,j)+arr[i-1]*arr[k]*arr[j];
            MIN=Math.min(MIN,temp);
        }
        return t[i][j]=MIN;
    }


    public static void main(String[] args) {
        int[] arr={40,20,30,10,30};
        int n= arr.length-1;
        MCM mcm=new MCM();
        int[][] t=new int[n+1][n+1];
        for(int[] obj:t){
            Arrays.fill(obj,-1);
        }
        System.out.println(mcm.recursive(arr,1, n));
        System.out.println(mcm.memoize(arr,t,1,n));
    }
}
