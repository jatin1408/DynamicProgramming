package com.company.Uncategorized;

public class DecreasingArray {
 //SOLUTION TAKEN FROM LEETCODE
        public boolean checkPossibility(int[] nums) {

            int change = 0;
            int k = 0;
            for (int i=1; i<nums.length; i++) {
                if (nums[i] < nums[i-1]) {
                    change++;
                    k = i;
                }
            }
            if (change > 1) {
                return false;
            }
            if (change == 0) {
                return true;
            }
            if (k == 1 || k == nums.length-1) {
                return true;
            }
            if (nums[k+1] < nums[k-1] && nums[k] < nums[k-2]) {
                return false;
            }
            return true;
        }
    }

