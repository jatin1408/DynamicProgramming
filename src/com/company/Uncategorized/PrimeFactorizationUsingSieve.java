package com.company.Uncategorized;

import java.util.Arrays;
public class PrimeFactorizationUsingSieve {
    static int[] arr=new int[1001];
    static int max=1001;
    public static void seive(){
        Arrays.fill(arr,-1);
        arr[1]=1;
        for(int i=2;i<max;i++){
            if(arr[i]==-1){
                for(int j=i;j<max;j+=i){
                    if(arr[j]==-1)
                    arr[j]=i;
                }
            }
        }
    }
    public static void factors(int n){
        while (n!=1){
            System.out.print(arr[n]+" ");
            n/=arr[n];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        seive();
        factors(74);
    }
}
