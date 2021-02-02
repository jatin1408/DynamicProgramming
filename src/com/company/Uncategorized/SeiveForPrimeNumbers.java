package com.company.Uncategorized;

import java.util.Arrays;

public class SeiveForPrimeNumbers {
    static int max=1001;
    static int[] arr=new int[max];
    public static void seive(){
        Arrays.fill(arr,-1);
        arr[1]=1;
        for(int i=2;i<max;i++){
            for(int j=i*i;j<max;j+=i){
                if(arr[j]==-1){
                    arr[j]=i;
                }
            }
        }

    }
    public static void printPrime(int n){
        for(int i=2;i<=n;i++){
            if(arr[i]==-1){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        seive();
        printPrime(45);
    }

}
