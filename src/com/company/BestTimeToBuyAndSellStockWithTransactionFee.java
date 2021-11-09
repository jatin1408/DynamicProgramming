package com.company;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[] b=new int[n];
        int[] na=new int[n];
        int[] s=new int[n];
        int[] r=new int[n];
        b[0]=-prices[0]-fee;
        s[0]=Integer.MIN_VALUE;
        na[0]=Integer.MIN_VALUE;
        r[0]=0;
        for(int i=1;i<n;i++){
            b[i]=Math.max(s[i-1],r[i-1])-prices[i]-fee;
            na[i]=Math.max(b[i-1],na[i-1]);
            s[i]=Math.max(b[i-1],na[i-1])+prices[i];
            r[i]=Math.max(s[i-1],r[i-1]);
        }
        return Math.max(Math.max(b[n-1],r[n-1]),Math.max(s[n-1],na[n-1]));
    }
}
