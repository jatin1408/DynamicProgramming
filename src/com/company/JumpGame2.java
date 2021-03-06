package com.company;

public class JumpGame2 {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1 || nums[0]==0){
            return 0;
        }
        int jumps=1;
        int max=nums[0];
        int curr_end=nums[0];
        for(int i=1;i<n;i++){
            if(i==n-1){
                return jumps;
            }
            max=Math.max(max,i+nums[i]);
            if(i==curr_end){
                jumps++;
                curr_end=max;
            }
        }
        return jumps;
    }
    //Another DP Solution
    public int maxJumps(int[] nums){
        int n=nums.length;
        if(n==1 || nums[0]==0){
            return 0;
        }
        int[] dp=new int[n];
        for(int i=1;i<n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(i<=j+nums[j] && dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
