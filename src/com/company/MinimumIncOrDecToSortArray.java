package com.company;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-increment-or-decrement-required-to-sort-the-array-top-down-approach/
public class MinimumIncOrDecToSortArray {
    static int[][] mem=new int[1000][1000];
    public static int fun(int[] arr,int N,int maxE,int minE){
        if(N==0) return 0;
        if(mem[N][maxE]!=0) return mem[N][minE];
        int ans=Integer.MAX_VALUE;
        for(int el=minE;el<=maxE;el++){
            int res=fun(arr,N-1,el,minE);
            ans=Math.min(ans,res+Math.abs(arr[N-1]-el));
        }
        return mem[N][maxE]=ans;

    }

    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        int min= Arrays.stream(arr).min().getAsInt();
        int max=Arrays.stream(arr).max().getAsInt();
        int n=arr.length;
        System.out.println(fun(arr,n,max,min));
    }
}
