package com.company;

import java.util.HashMap;

public class DigitDp {
    HashMap<StringBuilder,Integer> hashMap=new HashMap<>();
    int solve(String s,int n,int x,boolean tight,int len){
        if(x<0) return 0;
        if(n==1) {
            if (x >= 0 && x <= 9) {
                return 1;
            }
            return 0;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(n+"#");
        sb.append(x+"#");
        sb.append(tight+"#");
        if(hashMap.containsKey(sb)) return hashMap.get(sb);
        int ub=tight?s.charAt(len-n)-'0':9;
        int answer=0;
        for(int i=0;i<=ub;i++){
            answer+=solve(s,n-1,x-i,tight && i==ub,len);
        }
        hashMap.put(sb,answer);
        return answer;
    }

    public static void main(String[] args) {
        DigitDp dp=new DigitDp();
        System.out.println(dp.solve("11235",5,5,true,5));
    }
}
