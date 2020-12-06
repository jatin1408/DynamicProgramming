package com.company.Uncategorized;

public class WaveArray {

        static void swap(int arr[], int a, int b)
        {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        public static void convertToWave(int arr[], int n){
            // code here
            for(int i=0;i<n;i+=2){
                if(i>0 &&  arr[i-1]>arr[i]){
                    swap(arr,i,i-1);
                }
                if(i<n-1 && arr[i+1]>arr[i]){
                    swap(arr,i+1,i);
                }
            }
        }
    }

