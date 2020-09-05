package com.company;
class LIS {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        return lis(nums,n);
    }
    public int lis(int[] nums,int n){
        int[] output=new int[n];
        output[0]=1;
        for(int i=1;i<n;i++){
            output[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]>=nums[i]){
                    continue;
                }
                int temp=output[j]+1;
                if(temp>output[i]){
                    output[i]=temp;
                }
            }
        }
        int best=0;
        for(int i=0;i<n;i++){
            if(output[i]>best){
                best=output[i];
            }
        }
        return best;
    }
}