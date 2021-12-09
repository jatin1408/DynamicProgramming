package com.company;

public class PaintFenceDp {


        public int noOfWays(int n,int k){
            int diff=k*(k-1);
            int same=k;
            int total=same+diff;
            for(int i=3;i<=n;i++){
                same=diff;
                diff=total*(k-1);
                total=same+diff;
            }
            return total;

        }

        public static void main(String[] args) {
            PaintFenceDp s=new PaintFenceDp();
            System.out.println(s.noOfWays(2,4));
        }

}
