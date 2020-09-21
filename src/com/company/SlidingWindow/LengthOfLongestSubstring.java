package com.company.SlidingWindow;

import java.util.HashSet;

public class LengthOfLongestSubstring {

    public int findMax(String s){
        int res=0;
        HashSet<Character> hashSet=new HashSet<>();
        int i=0,j=0,ans=0,n=s.length();
        while (i<n && j<n){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }
            else
                hashSet.remove(s.charAt(i++));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="abcabb";
        LengthOfLongestSubstring l=new LengthOfLongestSubstring();
        System.out.println(l.findMax(s));
    }
}
