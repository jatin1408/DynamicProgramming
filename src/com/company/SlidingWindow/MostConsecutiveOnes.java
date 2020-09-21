package com.company.SlidingWindow;
//https://leetcode.com/problems/max-consecutive-ones-iii/
public class MostConsecutiveOnes {
    public int longestOnes(int[] a, int k) {
        int l=0,i=0;
        for(i=0;i<a.length;i++){
            if(a[i]==0)
                k--;

            if(k<0 && a[l++]==0)
                k++;
        }
        return i-l;
    }
}
