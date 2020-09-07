package com.company;

import java.util.Arrays;
import java.util.Stack;

public class PalindromePat {

    public int minNumberOfPartition(String s,int i,int j){
        if(i>=j){
            return 0;
        }
        if(isPalindrome(s,i,j)){

            return 0;
        }
        int best=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp=minNumberOfPartition(s,i,k)+minNumberOfPartition(s,k+1,j)+1;
            best=Math.min(temp,best);
        }
        return best;
    }
    public int minNumberOfPartitionMemoize(String s,int i,int j,int[][] t){

        if(i>=j){
            return 0;
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        if(isPalindrome(s,i,j)){

            return t[i][j]=0;
        }
        int best=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        for(int k=i;k<j;k++){
            if(t[i][k]!=-1){
                left=t[i][k];
            }
            else {
                left=minNumberOfPartitionMemoize(s,i,k,t);
            }
            if(t[k+1][j]!=-1){
                right=t[k+1][j];
            }
            else {
                right=minNumberOfPartitionMemoize(s,k+1,j,t);
            }
            int temp=left+right+1;
            best=Math.min(temp,best);
        }
        return t[i][j]=best;
    }
    public boolean isPalindrome(String s,int i,int j){
        //System.out.println(s.length());
        if(i>j){
            return true;
        }
        if(i==j){
            return true;
        }
        while (i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePat p=new PalindromePat();
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //String s="geek";
        int n=s.length();

        int[][] t=new int[2001][2001];
        for(int[] obj:t){
            Arrays.fill(obj,-1);
        }
        //System.out.println(p.minNumberOfPartition(s,0,n-1));
        System.out.println(p.minNumberOfPartitionMemoize(s,0,n-1,t));
        //System.out.println(p.isPalindrome("nitin",0,4));

    }
}
