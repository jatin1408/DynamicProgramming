package com.company;

import java.util.Stack;
//https://www.geeksforgeeks.org/sum-of-minimum-elements-of-all-subarrays/
public class SumSubarrayMinimums {
    static int findMinSum(int arr[], int n)
    {

        int CL[] = new int[n], CR[] = new int[n];
        Stack<Integer> q = new Stack<Integer>();

        for (int i = 0; i < n; i++)
        {
            while (!q.isEmpty() && arr[q.peek()] >= arr[i])
            {
                CL[i] += CL[q.peek()] + 1;
                q.pop();
            }
            q.push(i);
        }
        for(Integer obj:CL){
            System.out.print(obj+" ");
        }
        System.out.println();
        q.clear();


        for (int i = n - 1; i >= 0; i--)
        {
            while (!q.isEmpty() && arr[q.peek()] > arr[i])
            {
                CR[i] += CR[q.peek()] + 1;
                q.pop();
            }
            q.push(i);
        }

        q.clear();
        for(Integer obj:CR){
            System.out.print(obj+" ");
        }
        System.out.println();

        int ans = 0;


        for (int i = 0; i < n; i++)
            ans += (CL[i] + 1) * (CR[i] + 1) * arr[i];

        return ans;
    }


    public static void main(String[] args)
    {
        int arr[] = {3,1,2,4,0 };
        int n = arr.length;
        System.out.println(findMinSum(arr, n));
    }
}

