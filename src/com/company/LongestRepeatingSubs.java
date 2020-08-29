package com.company;

public class LongestRepeatingSubs {
    static int longestRepSub(String a){
        int m=a.length();
        int n=a.length();

        int[][] t=new int[m+1][n+1];

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                if(a.charAt(i-1)==a.charAt(j-1) && i!=j){
                    t[i][j]=1+t[i-1][j-1];
                }
                else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        for(int[] obj:t){
            for(int obj1:obj){
                System.out.print(obj1+" ");
            }
            System.out.println();
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        String a="aabb";
        System.out.println(longestRepSub(a));

    }
}
