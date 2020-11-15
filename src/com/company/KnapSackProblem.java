package com.company;

//Code written By Jatin Thakwani
public class KnapSackProblem {
    public int maxWeight(int[] val,int[] weight,int capacity){
        int rows=weight.length;
        int[][] dp=new int[rows+1][capacity+1];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=capacity;j++){
                dp[i][j]=dp[i-1][j];
                if(weight[i-1]<=j){
                    dp[i][j]=Math.max(dp[i][j],val[i-1]+dp[i-1][j-weight[i-1]]);
                }
            }
        }
        return dp[rows][capacity];
    }

    public static void main(String[] args) {
        KnapSackProblem k=new KnapSackProblem();
        int[] value={60,100,120};
        int[] weight={10,20,30};
        int capacity=50;
        System.out.println(k.maxWeight(value,weight,capacity)); //Output-220
    }
}
