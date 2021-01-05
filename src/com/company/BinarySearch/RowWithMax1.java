package com.company.BinarySearch;

public class RowWithMax1 {
    int binarySearch(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == 0 || arr[mid - 1] == 0 && arr[mid] == 1) {
                return mid;
            } else if (arr[mid] == 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int findMax(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int best = Integer.MAX_VALUE;
        int ans=-1;
        for (int i = 0; i < rows; i++) {
            int index = binarySearch(arr[i], 0, cols - 1);
            if (index != -1) {
                if(index<best){
                    best=index;
                    ans=i;
                }
            }
        }
        return ans;
    }
    int findMaxAnother(int[][] arr){
        int rows=arr.length;
        int cols=arr[0].length;
        int m=0;
        while (m<cols){
            int n=0;
            while (n<rows){
                if(arr[n][m]==1){
                    return n;
                }
                n++;
            }
            m++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1}};


        RowWithMax1 row = new RowWithMax1();
        System.out.println(row.findMax(arr));
        System.out.println(row.findMaxAnother(arr));
    }
}



