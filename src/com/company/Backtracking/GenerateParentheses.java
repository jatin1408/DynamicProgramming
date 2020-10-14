package com.company.Backtracking;

public class GenerateParentheses {
    public void generate(char[] arr,int pos,int open,int close,int n){
        if(close==n){
            String s=new String(arr);
            System.out.println(s);
        }
        if(open>close){
            arr[pos]=')';
            generate(arr,pos+1,open,close+1,n);
        }
        if(n>open){
            arr[pos]='(';
            generate(arr,pos+1,open+1,close,n);
        }

    }

    public static void main(String[] args) {
        GenerateParentheses g=new GenerateParentheses();
        int n=3;
        char[] arr=new char[n*2];
        g.generate(arr,0,0,0,n);
    }
}
