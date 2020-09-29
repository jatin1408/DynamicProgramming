package com.company.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LCS {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min=new ArrayDeque<>();
        Deque<Integer> max=new ArrayDeque<>();
        int i=0,j;
        for(j=0;j<nums.length;j++){
            while(!min.isEmpty() && nums[j]<min.peekLast()) min.pollLast();
            while(!max.isEmpty() && nums[j]>max.peekLast()) max.pollLast();
            max.add(nums[j]);
            min.add(nums[j]);
            if(max.peek()-min.peek()>limit){
                if(min.peek()==nums[i]) min.poll();
                if(max.peek()==nums[i]) max.poll();
                ++i;
            }
        }
        return j-i;
    }
}
