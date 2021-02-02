package com.company.Uncategorized;
//https://www.youtube.com/watch?v=LyMPfMe7T58&list=PL2q4fbVm1Ik7ip1VkWwe5U_CEb93vw6Iu&index=10&ab_channel=CodeNCode
//All the other pairs are going to repeat twice so they will have xor=0 and
//diagonal elements are going to come one so we will take them as sum
//example-(4,3,9,1) -> [4+3,4+9,4+1,4,4],[3+4,3+3,9+3,3+1]....


public class AllPairSumXOR {
    public static void main(String[] args) {
        int[] arr={2,4,1};
        int x=0;
        for(int i=0;i<arr.length;i++)
            x^=arr[i]*2;


        System.out.println(x);
    }
}
