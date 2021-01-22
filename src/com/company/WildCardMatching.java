package com.company;

public class WildCardMatching {
    //Code logic taken from Tushar Roy Video
    public boolean checkWildCards(String a,String b){
        char[] text=a.toCharArray();
        char[] pattern=b.toCharArray();
        int newIndex=0;
        boolean isFirst=true;
        int textLen= text.length;
        int patternLen= pattern.length;
        for(int i=0;i< patternLen;i++){
            if(pattern[i]=='*') {
                if (isFirst) {


                    pattern[newIndex++] = '*';
                    isFirst = false;
                }
            }
            else {
                pattern[newIndex++]=pattern[i];
                isFirst=true;
            }
        }
        boolean[][] t=new boolean[textLen+1][newIndex+1];
        if(newIndex>0 && pattern[0]=='*'){
            t[0][1]=true;
        }
        t[0][0]=true;

        for(int i=1;i<=textLen;i++){
            for(int j=1;j<=newIndex;j++){
                if(pattern[j-1]=='?' || text[i-1]==pattern[j-1]){
                    t[i][j]=t[i-1][j-1];
                }
                else if(pattern[j-1]=='*'){
                    t[i][j]=t[i-1][j] || t[i][j-1];

                }
            }
        }
        return t[textLen][newIndex];
    }
    //TOP-DOWN DP APPROACH



    public static void main(String[] args) {
        WildCardMatching wildCardMatching=new WildCardMatching();
        System.out.println(wildCardMatching.checkWildCards("xbylmz", "x?y*z"));
    }
}
