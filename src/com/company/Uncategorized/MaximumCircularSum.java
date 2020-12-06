package com.company.Uncategorized;

public class MaximumCircularSum {

        public int maxSubarraySumCircular(int[] a) {
            int MAX_SUM=Integer.MIN_VALUE;
            int MIN_SUM=Integer.MAX_VALUE;
            int sum=0;
            int temp_maxSum=0;
            int temp_minSum=0;
            for(int i=0;i<a.length;i++){
                sum+=a[i];
                temp_maxSum+=a[i];
                MAX_SUM=Math.max(temp_maxSum,MAX_SUM);
                temp_maxSum=temp_maxSum<0?0:temp_maxSum;

                temp_minSum+=a[i];
                MIN_SUM=Math.min(temp_minSum,MIN_SUM);
                temp_minSum=temp_minSum>0?0:temp_minSum;
            }
            if(sum==MIN_SUM){
                return MAX_SUM;
            }
            return Math.max(MAX_SUM,sum-MIN_SUM);
        }

}
