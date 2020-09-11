package com.company;

public class MinEditDistance {
    public int minDistance(char[] s1,char[] s2){
        int n1=s1.length;
        int n2=s2.length;
        int[][] t=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0)
                    t[i][j]=j;
                else if(j==0)
                    t[i][j]=i;
                else if(s1[i-1]==s2[j-1]){
                    t[i][j]=t[i-1][j-1];
                }
                else {
                    t[i][j]=Math.min(Math.min(t[i-1][j],t[i][j-1]),t[i-1][j-1])+1;
                }
            }
        }

        return t[n1][n2];
    }

    public static void main(String[] args) {
        MinEditDistance m=new MinEditDistance();
        String s1="horse";
        String s2="ros";
        System.out.println(m.minDistance(s1.toCharArray(),s2.toCharArray()));
    }
}
