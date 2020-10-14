package com.company;

public class DistinctSubsequences {
    public int getDistinct(char[] word,char[] target){
        int tLength=target.length;
        int wLength=word.length;
        int[][] t=new int[tLength+1][wLength+1];
        for(int i=0;i<=wLength;i++){
            t[0][i]=1;
        }
        for(int i=1;i<=tLength;i++){
            for(int j=1;j<=wLength;j++){
                if(target[i-1]==word[j-1]){
                    t[i][j]=t[i][j-1]+t[i-1][j-1];
                }
                else {
                    t[i][j]=t[i][j-1];
                }
            }
        }
        return t[tLength][wLength];
    }

    public static void main(String[] args) {
        DistinctSubsequences d=new DistinctSubsequences();
        System.out.println(d.getDistinct("banana".toCharArray(),"ban".toCharArray()));
    }
}
