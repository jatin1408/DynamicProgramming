package com.company.Uncategorized;

import java.util.HashMap;

public class SubArrayEqualsK {
    public int findSum(int[] arr,int target){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int n=arr.length;
        int sum=0;
        int res=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==target){
                res++;
            }
            if(hashMap.containsKey(sum-target)){
                res+=hashMap.get(sum-target);
            }
            int count=hashMap.getOrDefault(sum,0);
            hashMap.put(sum,count+1);
        }
        return res;
    }
}
