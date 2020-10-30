package com.company.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
//https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
public class LongestStringWithKUniqueCharacters {
    public static void longestString(String s,int k){
        Map<Character,Integer> hashMap=new HashMap<>();
        int l=0;

        int res=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int count=hashMap.getOrDefault(ch,0);
            hashMap.put(ch,count+1);
            if(hashMap.size()==k){
                System.out.println(s.substring(l,i));
                res=Math.max(res,i-l+1);
            }
            while (l<i && hashMap.size()>k){

                int u=hashMap.get(s.charAt(l));
                if(u==1){
                    hashMap.remove(s.charAt(l));
                }
                else {
                    hashMap.put(s.charAt(l),u-1);
                }
                if(hashMap.size()==k){
                    System.out.println(s.substring(l,i));
                    res=Math.max(res,i-l+1);
                }
                l++;
            }
        }
        System.out.println(res);
    }
}
