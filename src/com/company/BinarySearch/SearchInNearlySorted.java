package com.company.BinarySearch;

public class SearchInNearlySorted {
    public int binarySearch(int[] arr,int target,int n){

        int start=0;
        int end=n-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            if(mid+1<n && arr[mid+1]==target)
                return mid+1;
            if(mid-1>=0 && arr[mid-1]==target)
                return mid-1;
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInNearlySorted s=new SearchInNearlySorted();
        int[] arr={10, 3, 40, 20, 50, 80, 70};
        int n= arr.length;
        System.out.println(s.binarySearch(arr,40,n));
    }
}
