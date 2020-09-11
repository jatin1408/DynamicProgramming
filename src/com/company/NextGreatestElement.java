package com.company;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {
    public static int[] nextGreatest(int[] arr,int n){
        int[] res=new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            int next=arr[i];
            if(!stack.isEmpty()){
                int ind=stack.pop();
                int curr=arr[ind];
                while(curr<next){
                    res[ind]=next;
                    if(stack.isEmpty()){
                        break;
                    }
                    ind=stack.pop();
                    curr=arr[ind];
                }
                if(curr>next){
                    stack.add(ind);
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={4, 5, 2, 25};
        int n= arr.length;
        for(Integer obj:nextGreatest(arr,n)){
            System.out.print(obj+" ");
        }
    }
}
