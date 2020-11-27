package com.company;
import java.util.*;
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        return helper(nums,target,dp);

    }
    public int helper(int[] nums,int target,int[] dp){
        if(target==0)
            return 1;
        if(dp[target]!=-1)
            return dp[target];

        int res=0;
        for(int i=0;i<nums.length;i++)
            if(target>=nums[i])
                res+=helper(nums,target-nums[i],dp);


        return dp[target]=res;
    }
}
