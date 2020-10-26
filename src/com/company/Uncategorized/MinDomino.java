package com.company.Uncategorized;
//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
public class MinDomino {
    public int minDominoRotations(int[] A, int[] B) {
        int ans=min(swaps(A[0],A,B),swaps(A[0],B,A),swaps(B[0],A,B),swaps(B[0],B,A));
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int min(int a,int b,int c,int d){
        return Math.min(Math.min(Math.min(a,b),c),d);
    }
    public int swaps(int target,int[] a,int[] b){
        int swaps=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=target){
                if(b[i]!=target){
                    return Integer.MAX_VALUE;
                }
                else{
                    swaps++;
                }
            }
        }
        return swaps;
    }
}
