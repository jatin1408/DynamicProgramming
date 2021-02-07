package com.company.Uncategorized;

import java.util.HashMap;
import java.util.Set;
//https://leetcode.com/problems/longest-harmonious-subsequence/
public class LargestHarminousSeq {

        public static int findLHS(int[] nums) {
            HashMap<Integer,Integer> hashMap=new HashMap<>();
            for(int ele:nums){
                int val=hashMap.getOrDefault(ele,0);
                hashMap.put(ele,val+1);
            }
            Set<Integer> set=hashMap.keySet();
            int max=0;
            for(Integer ele:set){

                int val=hashMap.get(ele);
                int otval=hashMap.getOrDefault(ele+1,0);
                if(val+otval==val) continue;
                max=Math.max(max,val+otval);
            }
            System.out.println(max);
            return max;
        }

        public static void main(String[] args) {
            int[] nums={1,1,1,1};
            findLHS(nums);
        }
    }

