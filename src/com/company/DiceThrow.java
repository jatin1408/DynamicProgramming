package com.company;

import java.util.HashMap;

public class DiceThrow {
    HashMap<String,Integer> map=new HashMap<>();
    public int diceThrow(int m,int n,int sum){
        if(n==0 && sum==0)
            return 1;

        if(n==0)
            return 0;

        int res=0;
        String temp="";
        temp+=n;
        temp+='|';
        temp+=sum;
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        for(int i=1;i<=m;i++)
            res+=diceThrow(m,n-1,sum-i);
        map.put(temp,res);
        return res;
    }
}
