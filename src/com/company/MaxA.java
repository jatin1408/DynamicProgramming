package com.company;

public class MaxA {
    static int findMax(int n){
        if(n<=6){
            return n;
        }
        int i;
        int max=0;

        for(i=n-3;i>=0;i--){
            int curr=(n-i-1)*findMax(i);
            max=Math.max(curr,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMax(7));
    }
}
