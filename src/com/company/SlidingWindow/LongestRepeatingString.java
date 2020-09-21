package com.company.SlidingWindow;
//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingString {
    public int longestRepeating(String s,int k){
        int[] c=new int[26];
        int left=0,right;
        int max=0;
        int mostFrequent=0;
        for(right=0;right<s.length();right++){
            mostFrequent=Math.max(mostFrequent,++c[s.charAt(right)-'A']);
            int temp=(right-left+1)-mostFrequent;
            if(temp>k){
                c[s.charAt(left)-'A']--;
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
