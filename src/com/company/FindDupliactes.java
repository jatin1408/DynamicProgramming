package com.company;
//CODE TO FIND DUPLICATES IN ARRAY IN o(n) time
public class FindDupliactes {
    static void  findDuplicates(int[] arr,int n){
        //numbers are from 0 to n-1
        for(int i=0;i<n;i++){
            if(arr[Math.abs(arr[i])]>=0){
                arr[Math.abs(arr[i])]=-arr[ Math.abs(arr[i])];
            }
            else {
                System.out.print(Math.abs(arr[i])+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,2,3,4,4};
        findDuplicates(arr,arr.length);

    }
}
