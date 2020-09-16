package com.company;

import java.util.HashMap;
//137ms
class TargetSum{
    HashMap<String,Integer> hashMap=new HashMap<>();
    public int findTargetSumWays(int[] nums, int S) {
        return targetSum(nums,S,nums.length-1,0);
    }

    public int targetSum(int[] arr,int target,int index,int currSum){
        if(index<0 && target==currSum)
            return 1;
        if(index<0)
            return 0;
        String temp=Integer.toString(index);
        temp+="|";
        temp+=currSum;
        if(hashMap.containsKey(temp)){
            return hashMap.get(temp);
        }
        int positiveSum=targetSum(arr,target,index-1,currSum+arr[index]);
        int negativeSum=targetSum(arr,target,index-1,currSum+arr[index]*-1);
        int ans=positiveSum+negativeSum;
        hashMap.put(temp,ans);
        return ans;
    }
}
