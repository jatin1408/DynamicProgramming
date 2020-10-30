package com.company;

public class DecodeWays {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==0)
            return 0;
        int[] arr=new int[n+1];
        arr[0]=1;
        arr[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++){
            int one=Integer.valueOf(s.substring(i-1,i));
            int two=Integer.valueOf(s.substring(i-2,i));
            if(one>0){
                arr[i]+=arr[i-1];
            }
            if(two>=10 && two<=26){
                arr[i]+=arr[i-2];
            }
        }
        
        return arr[n];
    }

    public static void main(String[] args) {
        DecodeWays d=new DecodeWays();
        System.out.println(d.numDecodings("226"));

    }
}
