package com.company;
//https://www.geeksforgeeks.org/maximize-sum-of-k-elements-in-array-by-taking-only-corner-elements/
public class MaximizeSumOfKElements {
    public int maxKElements(int[] nums,int k){
        int r=nums.length-1;
        int sum=0;
        int max=0;
        int l=k-1;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        max=sum;
        for(int i=0;i<k;i++){
            sum-=nums[l--];
            sum+=nums[r--];
            max=Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={2, 1, 14, 6, 4, 3};
        MaximizeSumOfKElements m=new MaximizeSumOfKElements();
        System.out.println(m.maxKElements(a,3));
    }
}
