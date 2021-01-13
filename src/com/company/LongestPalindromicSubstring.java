package com.company;

public class LongestPalindromicSubstring {
    public static int longestPalindromic(String a){
        int n=a.length();
        int[][] t=new int[n][n];
        for(int i=0;i<n;i++)
        t[i][i]=1;
        int start=0;
        int end=1;
for(int i=0;i<n-1;i++) {
    if(a.charAt(i)==a.charAt(i+1)) {
        t[i][i + 1] = 1;
        start=i;
        end=2;
    }

}
        for(int l=3;l<n;l++){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                if(a.charAt(i)==a.charAt(j) && t[i+1][j-1]==1){
                    t[i][j]=1;
                    if(l>end){
                        start=i;
                        end=l;

                    }
                }
            }
        }
        return start+end-start;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromic("babad"));
    }
}
