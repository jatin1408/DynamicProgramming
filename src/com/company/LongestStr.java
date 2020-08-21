package com.company;

public class LongestStr {
    public static int recursive(char[] x,char[] y,int m,int n,int res){
        if(m==0 || n==0)
            return res;

        if(x[m-1]==y[n-1])
            res= recursive(x,y,m-1,n-1,res+1);
        return Math.max(res,Math.max(recursive(x,y,m-1,n,0),recursive(x,y,m,n-1,0)));
    }
    public static int longest(String a,String b){
        int m=a.length();
        int n=b.length();

        int[][] t=new int[m+1][n+1];
        int result=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                    result = Integer.max(result, t[i][j]);
                }
                else {
                    t[i][j]=0;
                }
            }
        }
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        String a="abcde";
        String b="abfce";
        //System.out.println(longest(a,b));
        System.out.println(recursive(a.toCharArray(),b.toCharArray(),a.length(),b.length(),0));
    }
}
