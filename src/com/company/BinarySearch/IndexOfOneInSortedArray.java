package com.company.BinarySearch;
//Find index of first one in infinite sorted array :)
public class IndexOfOneInSortedArray {
    public int firstOne(int[] arr){
        int start=0;
        int end=1;
        while (arr[end]!=1){
            start=end;
            end*=2;
        }
        int res=Integer.MAX_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==1){
                res=Math.min(mid,res);
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return res;
    }
}
