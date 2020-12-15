package com.company.Uncategorized;
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//Solution taken from leetcode
//a%60+b%60==60
public class Modulo60Pairs {
    public int gePairs(int[] time){
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}
