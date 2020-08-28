package com.company;

import java.util.Arrays;

public class LargestSumRectangle {
    static class Result{
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int lowBound;
        @Override
        public String toString() {
            return "Result [maxSum=" + maxSum + ", leftBound=" + leftBound
                    + ", rightBound=" + rightBound + ", upBound=" + upBound
                    + ", lowBound=" + lowBound + "]";
        }

    }
    static class Kadane{
        int start;
        int end;
        int sum;

        public Kadane(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
    private Kadane maxSum(int[] arr){
        int max_so_far=0;
        int max_start=-1;
        int max_end=-1;
        int max_rn=0;
        int current_start=0;
        for(int i=0;i<arr.length;i++){
            max_rn+=arr[i];
            if(max_rn<0){
                max_rn=0;
                current_start=i+1;
            }
            if(max_rn>max_so_far){
                max_so_far=max_rn;
                max_start=current_start;
                max_end=i;
            }
        }
        return new Kadane(max_start,max_end,max_so_far);
    }
    private void getMaxSum(int[][] arr){
        int rows=arr.length;
        int cols=arr[0].length;
        Result result= new Result();
        int[] temp=new int[rows];
        for(int left=0;left<cols;left++){
            Arrays.fill(temp,0);
            for(int right=left;right<cols;right++){
                for(int i=0;i<rows;i++){
                    temp[i]+=arr[i][right];
                }
                Kadane k=maxSum(temp);
                if(k.sum>result.maxSum){
                    result.maxSum=k.sum;
                    result.leftBound=left;
                    result.rightBound=right;
                    result.upBound=k.start;
                    result.lowBound=k.end;

                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[][] arr={{2,0,2,-3},{1,6,-2,3},{-3,3,-1,1},{-4,4,4,0},{5,1,-5,3}};
        LargestSumRectangle largestSumRectangle=new LargestSumRectangle();
        largestSumRectangle.getMaxSum(arr);
    }
}
