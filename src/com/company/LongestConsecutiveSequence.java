package com.company;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
public class LongestConsecutiveSequence {
    //o(n) method
        public int longestConsecutive(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(num);
            }
            int best=0;
            for(int num:nums){
                if(!set.contains(num-1)){
                    int currNum=num;
                    int streak=1;
                    while(set.contains(currNum+1)){
                        streak++;
                        currNum++;
                    }
                    best=Math.max(streak,best);
                }
            }
            return best;
        }
        //o(nlogn) method
        public int longestConsecutiveSorting(int[] nums) {

            int n=nums.length;
            if(n==0) return n;
            Arrays.sort(nums);
            int[] dp=new int[n];
            dp[0]=1;
            for(int i=1;i<n;i++){
                if(nums[i]-nums[i-1]==1){
                    dp[i]=dp[i-1]+1;
                }
                else if(nums[i]==nums[i-1]) dp[i]=dp[i-1];
                else{
                    dp[i]=1;
                }
            }
            int best=0;
            for(int i=0;i<n;i++){
                best=Math.max(dp[i],best);
            }
            return best;
        }


}
