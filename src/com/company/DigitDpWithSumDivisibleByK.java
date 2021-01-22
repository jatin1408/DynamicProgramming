package com.company;
//https://www.geeksforgeeks.org/count-n-digits-numbers-with-sum-diviasible-by-k/
public class DigitDpWithSumDivisibleByK {
    static int[][][] dp=new int[1000][1000][2];
    public static int fun(int n,int k,int sum,int st,int[][][] dp){
        if(n==0 && sum==0){
            return 1;
        }
        if(n<0) return 0;
        int start=st==0?1:0;
        int res=0;
        if(dp[n][sum][st]!=Integer.MAX_VALUE) return dp[n][sum][st];
        for(int i=start;i<=9;i++){
            res+=fun(n-1,k,(sum+i)%k,(st|i) >0?1:0,dp);
        }
        return dp[n][sum][st]=res;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++)
            for(int j = 0; j < 1000; j++)
                for(int k = 0; k < 2; k++)
                    dp[i][j][k] = Integer.MAX_VALUE;
        System.out.println(fun(2,7,0,0,dp));
    }


}
