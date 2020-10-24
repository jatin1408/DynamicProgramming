package com.company.Uncategorized;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
public class MaximizeTheDifference {
    public int maximize(int[] arr,int k){
        Arrays.sort(arr);
        int n=arr.length-1;
        int ans = arr[n] - arr[0];
        int min=arr[0]+k;
        int max=arr[n]-k;

        for(int i=1;i<=n;i++){
            int small=arr[i]-k;
            int big=arr[i]+k;
            if (small >= min || big <= max)
                continue;
            if(small<min){
                min=small;
            }
            else {
                max=big;
            }
        }
        return Math.min(max-min,ans);
    }

    public static void main(String[] args) {
        int[] arr={1, 10, 14, 14, 14, 15};
        MaximizeTheDifference maximizeTheDifference=new MaximizeTheDifference();
        System.out.println(maximizeTheDifference.maximize(arr,6));
    }
}
