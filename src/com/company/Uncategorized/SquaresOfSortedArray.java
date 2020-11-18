package com.company.Uncategorized;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        int n=A.length;
        int[] res=new int[n];
        int r=n-1;
        int l=0;
        int index=n-1;
        for(int i=0;i<n;i++){
            if(Math.abs(A[l])>A[r]){
                res[index--]=A[l]*A[l];
                l++;
            }
            else{
                res[index--]=A[r]*A[r];
                r--;
            }
        }

        return res;
    }
}
