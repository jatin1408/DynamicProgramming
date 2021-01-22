package com.company;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
//https://leetcode.com/problems/largest-divisible-subset/
public class LargestDivisibleSubset {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n=nums.length;
            int[] dp=new int[n];
            int[] pre=new int[n];
            Arrays.sort(nums);

            int max=0;
            int index=-1;
            for(int i=0;i<n;i++){
                dp[i]=1;
                pre[i]=-1;
                for(int j=i-1;j>=0;j--){
                    if(nums[i]%nums[j]==0){
                        if(dp[j]+1>dp[i]){
                            dp[i]=dp[j]+1;
                            pre[i]=j;
                        }
                    }
                }
                if(dp[i]>max){
                    max=dp[i];
                    index=i;
                }
            }
            List<Integer> result=new ArrayList<>();
            while(index!=-1){
                result.add(nums[index]);
                index=pre[index];
            }
            return result;
        }
    }

