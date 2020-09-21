package com.company.SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String maxString(String s,String t){
        HashMap<Character,Integer> target=new HashMap<>();
        HashMap<Character,Integer> whole=new HashMap<>();
        int[] ans={-1,0,0};
        for(int i=0;i<t.length();i++){
            int count=target.getOrDefault(t.charAt(i),0);
            target.put(t.charAt(i),++count);
        }

        int required=target.size();
        int l=0,r=0;
        int formed=0;
        while (r<s.length()){
            char c=s.charAt(r);
            int count=whole.getOrDefault(c,0);
            whole.put(c,++count);
            if(target.containsKey(c) && target.get(c).intValue()==whole.get(c).intValue())
                formed++;
            while(l<=r && formed==required){
                c=s.charAt(l);
                if(ans[0]==-1 || r-l+1<ans[0]){
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                whole.put(c,whole.get(c)-1);
                if(target.containsKey(c) && target.get(c).intValue()>whole.get(c).intValue()){
                    formed--;
                }
                l++;
            }
            r++;
        }

        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m=new MinimumWindowSubstring();
        System.out.println(m.maxString("ADOBECODEBANC","ABC"));

    }
}
