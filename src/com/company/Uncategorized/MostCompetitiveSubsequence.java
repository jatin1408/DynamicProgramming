package com.company.Uncategorized;
import java.util.Stack;
//https://leetcode.com/problems/find-the-most-competitive-subsequence/
public class MostCompetitiveSubsequence {
            public int[] mostCompetitive(int[] nums, int k) {
            int n=nums.length;
            int minElement=nums[0];
            int minIndex=0;
            for(int i=1;i<n;i++){
                if(nums[i]<minElement && n-i>=k){
                    minElement=nums[i];
                    minIndex=i;
                }
            }
            Stack<Integer> stack=new Stack<>();
            stack.push(minIndex);
            for(int i=minIndex+1;i<n;i++){
                while(!stack.isEmpty() && nums[stack.peek()]>nums[i] &&
                        n-i>k-stack.size())
                {

                    stack.pop();
                }
                stack.push(i);
            }
            while (stack.size()>k){
                stack.pop();
            }
            int[] res=new int[k];
            int index=k-1;
            while(!stack.isEmpty()){

                res[index--]=nums[stack.pop()];
            }
            return res;
        }
    }

