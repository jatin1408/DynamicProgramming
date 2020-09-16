package com.company.BinarySearch;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        if(n==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[end]>nums[end-1])
            return end;
        start+=1;
        end-=1;
        while(start<=end){
            int m=start+(end-start)/2;
            if(m>0 && m<n-1){
                if(nums[m-1]<nums[m] && nums[m+1]<nums[m]){
                    return m;
                }
                else if(nums[m-1]>nums[m]){
                    end=m-1;
                }
                else{
                    start=m+1;
                }
            }
        }
        return -1;
    }
}
