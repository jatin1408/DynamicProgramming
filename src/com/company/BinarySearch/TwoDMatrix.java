package com.company.BinarySearch;

public class TwoDMatrix {
    boolean searchTwoMatrix(int[][] arr,int target){
        int i=0;
        int n=arr.length;
        int m=arr[0].length;
        int j=m-1;
        while (i>=0 && i<n && j>=0 && j<m){
            if(arr[i][j]==target){
                return  true;
            }
            else if(arr[i][j]>target){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }


}
