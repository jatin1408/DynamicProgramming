package com.company;

public class PrintSCS {
    public String printSCS(String a,String b){
        int m=a.length();
        int n=b.length();

        int[][] t=new int[m+1][n+1];
        for(int i=0;i<m;i++){

            t[i][0]=0;

        }
        for(int i=0;i<n;i++){
            t[0][i]=0;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }
                else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        int i=m;
        int j=n;
        StringBuilder res=new StringBuilder();

        while (i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                res.append(a.charAt(i-1));
                i--;
                j--;

            }
            else {
                if(t[i][j-1]>t[i-1][j]) {
                    res.append(b.charAt(j-1));
                    j--;
                }
                else  {
                    res.append(a.charAt(i-1));
                    i--;
                }
            }

        }
        while (i>0){

            res.append(a.charAt(i-1));
            i--;
        }
        while (j>0){

            res.append(b.charAt(j-1));
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        PrintSCS scs=new PrintSCS();
        System.out.println(scs.printSCS("aaaaaaaaaa","aaaaaaaa"));
    }
}
