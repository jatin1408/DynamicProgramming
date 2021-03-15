package com.company.BinarySearch;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
public class FindKClosest {
    public void find(int[] arr,int target,int k,int n){
        Arrays.sort(arr);
        int inPoint=Arrays.binarySearch(arr,target);
       int r=inPoint+1;
       int l=inPoint-1;
       int count=0;
      while (l>=0 && r<n && count<k){
          if(target-arr[l]<arr[r]-target){
              System.out.print(arr[l--]+" ");
          }
          else {
              System.out.print(arr[r++]+" ");
          }
          count++;
      }


    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        FindKClosest f=new FindKClosest();
        f.find(arr,3,4,arr.length);
    }
}
