package com.company;
//https://www.geeksforgeeks.org/find-element-array-sum-left-array-equal-sum-right-array/
public class SumEqualIndex {
    public int getBreakPoint(int[] arr){
        int n=arr.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        prefix[0]=arr[0];
        suffix[n-1]=arr[n-1];
        for(int i=1;i<n;i++)
            prefix[i]=arr[i]+prefix[i-1];
        for(int i=n-2;i>=0;i--)
            suffix[i]=arr[i]+suffix[i+1];
        for(int i=0;i<n;i++)
            if(prefix[i]==suffix[i])
                return i;
        return -1;
    }

    public static void main(String[] args) {
        SumEqualIndex s=new SumEqualIndex();
        System.out.println(s.getBreakPoint(new int[]{1,4,2,5}));
    }
}
