package com.company.Uncategorized;

public class CheckingKthSetBit {
    static boolean setBit(int n,int k){
        //FOR NEGATIVE NUMBERS
        // if((n >> i & 1) == 1)
        int f=1;
        int ans=f <<k-1;

        return (ans & n)>0?true:false;
    }

    public static void main(String[] args) {
        System.out.println(setBit(11,3));
    }
}
