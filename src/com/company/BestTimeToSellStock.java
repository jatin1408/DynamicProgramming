package com.company;

public class BestTimeToSellStock {
    //question link- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        public int maxProfit1(int[] a) {
            int max=0;
            for(int i=0;i<a.length;i++){
                int p=a[i];
                for(int j=i+1;j<a.length;j++){
                    if(a[j]>p){
                        if(a[j]-p>max){
                            max=a[j]-p;

                        }

                    }
                }
            }
            return max;
        }
        //question link-https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        public int maxProfit2(int[] prices) {
            int n = prices.length;

            int diff = 0;
            for(int i=1;i<n;++i)
            {
                if(prices[i] > prices[i-1])
                    diff += prices[i]-prices[i-1];
            }
            return diff;
        }
        //question link-https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
        public int maxProfitWithCoolDown(int[] arr,int curr,int n,int[] t){
            if(curr>=n)
                return 0;
            if(t[curr]!=-1)
                return t[curr];
            int maxVal=0;
            for(int i=curr+1;i<n;i++)
                if(arr[i]>arr[curr])
                    maxVal=Math.max(maxVal,arr[i]-arr[curr]+maxProfitWithCoolDown(arr, i+2, n, t));

            maxVal=Math.max(maxVal,maxProfitWithCoolDown(arr,curr+1,n,t));
            return t[curr]=maxVal;
        }
       //question link-https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
        public int maxProfitWithCoolDownWithStates(int[] arr,int n){
            if(n<=1)
                return 0;

            int[] noStock=new int[n];
            int[] inHand=new int[n];
            int[] sold=new int[n];
            noStock[0]=0;
            inHand[0]=-arr[0];
            sold[0]=0;
            for(int i=1;i<n;i++){
                noStock[i]=Math.max(noStock[i-1],sold[i-1]);
                inHand[i]=Math.max(inHand[i-1],noStock[i-1]-arr[i]);
                sold[i]=inHand[i-1]+arr[i];
            }
            return Math.max(noStock[n-1],sold[n-1]);
        }
        //video-https://www.youtube.com/watch?v=37s1_xBiqH0&t=428s&ab_channel=TECHDOSE
        //question link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        public int maxProfitWith2Transaction(int[] arr,int n){
            if(n==0){
                return 0;
            }
            int[] left=new int[n];
            int[] right=new int[n];
            int leftMin=arr[0];
            int rightMax=arr[n-1];
            for(int i=0;i<n;i++){
                left[i]=Math.max(left[i-1],arr[i]-leftMin);
                leftMin=Math.min(leftMin,arr[i]);
            }
            for(int i=n-2;i>=0;i--){
                right[i]=Math.max(right[i+1],rightMax-arr[i]);
                rightMax=Math.max(rightMax,arr[i]);
            }
            int maxProfit=0;
            for(int i=1;i<n;i++)
                maxProfit=Math.max(maxProfit,left[i-1]+right[i]);
            return maxProfit;
        }

    }

