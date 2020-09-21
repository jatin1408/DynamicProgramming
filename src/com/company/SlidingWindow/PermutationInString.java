package com.company.SlidingWindow;
//https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {
    public boolean check(String a,String b){
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        int na=a.length();
        int nb=b.length();
        if(na>nb){
            return false;
        }
        for(int i=0;i<na;i++){
            arr1[a.charAt(i)-'a']++;
            arr2[b.charAt(i)-'a']++;
        }
        for(int i=0;i<nb-na;i++){
            if(matches(arr1,arr2))
                return true;
            arr2[b.charAt(i+na)-'a']++;
            arr2[b.charAt(i)-'a']--;
        }
        return matches(arr1,arr2);
    }
    public boolean matches(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }
}
