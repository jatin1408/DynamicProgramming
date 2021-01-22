package com.company.Uncategorized;

public class MinimumOperationsToMakeXZero {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        int target=sum-x;
        int curr=0,high=0,len=-1;
        if(target==0) return 0;
        if(target<0) return -1;
        for(int i=0;i<n;i++){
            if(curr<target) curr+=nums[i];
            while(curr>=target){

                if(curr==target) len=Math.max(len,i-high+1);
                curr-=nums[high++];
            }
        }
        return len==-1?-1:n-len;
    }
}
