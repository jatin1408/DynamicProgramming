package com.company.BinarySearch;

public class FloorOfSortedArray {
    public int binarySearch(int[] arr,int ele){
        int low=0;
        int high=arr.length-1;
        int res=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<ele){
                res=Math.max(arr[mid],res);
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return res;
    }
    public int binarySearchCeil(int[] arr,int ele){
        int low=0;
        int high=arr.length-1;
        int res=arr[high];
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>ele){
                res=Math.min(arr[mid],res);
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return res;
    }

    public static void main(String[] args) {
        FloorOfSortedArray f=new FloorOfSortedArray();
        int[] arr={1,2,3,4,6,8,9,10};
        System.out.println(f.binarySearch(arr,11));
        System.out.println(f.binarySearchCeil(arr,1));
    }
}
