package com.company.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    int maxMinDistance(int[] arr,int n){
        Arrays.sort(arr);
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(check(arr,n,mid)){
                ans=mid;
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return ans;
    }
    boolean check(int[] arr,int n,int distance){
        int first=arr[0];
        int count=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]-first>=distance){
                first=arr[i];
                count++;
            }
            if(count==n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AggressiveCows a=new AggressiveCows();
        System.out.println(a.maxMinDistance(new int[]{1,2,4,8,9},3));
    }
}
