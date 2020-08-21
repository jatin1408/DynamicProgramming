package com.company;

public class RodCutting {
    //FOR RECURSION UNDERSTANDING
    /*cR() ---> cutRod()

    cR(4)
                  /        /
                          /        /
    cR(3)       cR(2)     cR(1)   cR(0)
            /  |         /         |
            /   |        /          |
    cR(2) cR(1) cR(0) cR(1) cR(0) cR(0)
            /        |          |
            /         |          |
    cR(1) cR(0) cR(0)      cR(0)
            /
            /
    CR(0)*/
    public int max(int[] price,int n){
        int[] val=new int[n+1];
        val[0]=0;
        for(int i=0;i<=n;i++){
            int prev=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                prev=Math.max(prev,price[j]+val[i-j-1]);
            }
            val[i]=prev;
        }
        return val[n];
    }
    
}
