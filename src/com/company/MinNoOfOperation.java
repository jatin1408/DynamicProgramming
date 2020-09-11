package com.company;

import java.util.Arrays;

//https://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/
public class MinNoOfOperation {
    public int maxOperation(int[] arr,int l,int r,int[][] t){
        if(l>=r){
            return 0;
        }
        if(t[l][r]!=-1){
            return t[l][r];
        }
        int min=getMin(arr,l,r);
        int max=getMax(arr,l,r);
        if(min*2>max){
            return 0;
        }
        return t[l][r]=Math.min(maxOperation(arr,l+1,r,t),maxOperation(arr,l,r-1,t))+1;
    }
    public int getMin(int[] arr,int l,int r){
        int min=arr[l];
        for(int i=l+1;i<=r;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    public int getMax(int[] arr,int l,int r){
        int max=arr[l];
        for(int i=l+1;i<=r;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={4, 5, 100, 9, 10, 11, 12, 15, 200};
        MinNoOfOperation minNoOfOperation=new MinNoOfOperation();
        int n=a.length;
        int[][] t=new int[n][n];
        for(int[] obj:t){
            Arrays.fill(obj,-1);
        }
        System.out.println(minNoOfOperation.maxOperation(a,0,n-1,t));
    }
}
