package com.company.BinarySearch;

public class LastAndFirstOccurrences {

    static public int first(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=low+high/2;
            if(arr[mid]==x && (mid==0 || arr[mid-1]<x)){
                return mid;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    static public int last(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=low+high/2;
            if(arr[mid]==x && (mid==arr.length-1 || arr[mid+1]>x)){
                return mid;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,4,5,8};
        System.out.println(first(arr,1));
        System.out.println(last(arr,1));
    }
}
