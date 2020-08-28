package com.company;

import java.util.Collections;

//Longest Substring without Repetition
public class LongestStrWithoutRep {
    static int findMax(String a){
        int max=0;
        int n=a.length();
        boolean[] arr=new boolean[256];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[a.charAt(j)]){
                    break;
                }
                else {
                    max=Math.max(max,j-i+1);
                    arr[a.charAt(j)]=true;
                }

            }
            arr[a.charAt(i)]=false;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMax("geeksforgeeks"));
    }
}
