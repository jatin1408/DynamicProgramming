package com.company;

import java.util.Arrays;

//https://www.geeksforgeeks.org/longest-subsequence-having-difference-atmost-k/
public class LongestSequenceWithKDiff {
    public int getLongest(char[] s,int k){
        int n=s.length;
        if(n==0)
            return 1;
        int[] output=new int[n];
        Arrays.fill(output,1);

        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(Math.abs(s[i]-s[j])<=k){
                    output[i]=Math.max(output[i],output[j]+1);
                }
            }
        }
        int best=output[0];
        for(int i=1;i<n;i++){
            best=Math.max(best,output[i]);
        }
        return best;
    }

    public static void main(String[] args) {
        LongestSequenceWithKDiff l=new LongestSequenceWithKDiff();
        System.out.println(l.getLongest("abhgfced".toCharArray(),2));
    }
}
