package com.company.BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search=new BinarySearch();
        int[] arr={1,2,5,7,9};
        System.out.println(search.binarySearch(arr,9));
    }
}
