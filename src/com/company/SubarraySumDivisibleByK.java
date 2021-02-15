package com.company;
import java.util.HashMap;
public class SubarraySumDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);
        int ans=0;
        int sum=0;
        for(int ele:A){
            sum+=ele;
            int rem=sum%K;
            if(rem<0)
                rem+=K;
            if(hashMap.containsKey(rem)){
                ans+=hashMap.get(rem);
                hashMap.put(rem,hashMap.get(rem)+1);
            }
            else
                hashMap.put(rem,1);


        }
        return ans;
    }
}
