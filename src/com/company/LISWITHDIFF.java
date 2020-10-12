package com.company;
//https://www.geeksforgeeks.org/longest-subsequence-such-that-difference-between-adjacents-is-one/
public class LISWITHDIFF {
    int getMax(int[] arr){
        int n=arr.length;
        int[] dp=new int[arr.length];
        dp[0]=1;
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                if(arr[i]==arr[j] +1 || arr[i]==arr[j]-1){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int best=dp[0];
        for(int i=1;i<n;i++){
            if(best<dp[i]){
                best=dp[i];
            }
        }
        return best;
    }

    public static void main(String[] args) {
        LISWITHDIFF liswithdiff=new LISWITHDIFF();
        System.out.println(liswithdiff.getMax(new int[]{10, 9, 4, 5, 4, 8, 6}));

    }
}
