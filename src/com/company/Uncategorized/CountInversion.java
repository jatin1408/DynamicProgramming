package com.company.Uncategorized;

import java.util.Arrays;

public class CountInversion {
    static int getCount(int l,int m,int r,int[] arr){
        int[] left= Arrays.copyOfRange(arr,l,m+1);
        int[] right=Arrays.copyOfRange(arr,m+1,r+1);
        int index=l,swaps=0,i=0,j=0;
        while (i<left.length && j<right.length){
            if(left[i]<right[j])
                arr[index++]=left[i++];
            else {
                arr[index++]=right[j++];
                swaps+=(m+1)- (l+i);
            }

        }
        return swaps;
    }
    public static int merge(int[] arr,int left,int right){
        int count=0;
        if(left<right){
            int mid=(left+right)/2;
            count+=merge(arr,left,mid);
            count+=merge(arr,mid+1,right);
            count+=getCount(left,mid,right,arr);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr={ 1, 20, 6, 4, 5};
        System.out.println(merge(arr,0,arr.length-1));
    }
}
