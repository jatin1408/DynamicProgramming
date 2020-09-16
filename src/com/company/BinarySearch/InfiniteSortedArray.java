package com.company.BinarySearch;

public class InfiniteSortedArray {
    public int binarySearch(int[] arr,int key){
        int start=0;
        int end=1;
        while (key>arr[end]){
            start=end;
            end=end*2;
        }
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return -1;
    }
}
