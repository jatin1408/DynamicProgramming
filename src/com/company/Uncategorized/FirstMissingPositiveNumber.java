package com.company.Uncategorized;

public class FirstMissingPositiveNumber {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int shift=splitArray(nums,n);
        int[] arr=new int[n-shift];
        int j=0;
        for(int i=shift;i<n;i++){
            arr[j++]=nums[i];
        }
        return firstMissing(arr,j);

    }
    public int splitArray(int[] arr,int n){
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        return j;
    }
    public int firstMissing(int[] arr,int n){
        for(int i=0;i<n;i++){
            int x=Math.abs(arr[i]);
            if(x-1<n && arr[x-1]>0){
                arr[x-1]=-arr[x-1];
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
