package com.company;

import java.util.Stack;

public class LargestAreaInHistogram {
   public int maxAreaInHist(int[] arr){
       Stack<Integer> stack=new Stack<>();
       int area=0;
       int maxArea=0;
       int i;
       for(i=0;i<arr.length;){
           if(stack.empty() || arr[stack.peek()]<=arr[i]){
                stack.push(i);
                   i++;
           }
           else {
               int top=stack.pop();
               if(stack.isEmpty()){
                   area=arr[top]*i;
               }
               else {
                   area=arr[top]*(i-stack.peek()-1);

               }
               maxArea=Math.max(maxArea,area);
           }
       }
       while (!stack.isEmpty()){
           int top=stack.pop();
           if(stack.isEmpty()){
               area=arr[top]*i;
           }
           else {
               area=arr[top]*(i-stack.peek()-1);
           }
           maxArea=Math.max(maxArea,area);
       }
       return maxArea;
   }

    public static void main(String[] args) {
        LargestAreaInHistogram largestAreaInHistogram=new LargestAreaInHistogram();
        System.out.println(largestAreaInHistogram.maxAreaInHist(new int[]{2,1,5,6,2,3}));
    }
}
