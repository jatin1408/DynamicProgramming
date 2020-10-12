package com.company.Backtracking;

import java.util.Arrays;

public class KnightTour {
    static  int n=6;
    void startKnightTour(){
        int[][] sol=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(sol[i],-1);
        sol[0][0]=0;
        if(knightTour(sol,0,0,1)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(sol[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
    boolean knightTour(int[][] sol,int x,int y,int steps){
        if(n*n==steps)
            return true;

                int[] x1={2,1,-1,-2,-2,-1,1,2};
                int[] y1={1, 2, 2, 1, -1, -2, -2, -1};
                for(int i=0;i<8;i++){
                    int nX1=x+x1[i];
                    int nY1=y+y1[i];
                    if(isValid(nX1,nY1)) {
                        if (sol[nX1][nY1] == -1) {
                            sol[nX1][nY1] = steps ;
                            if (knightTour(sol, nX1, nY1, steps + 1))
                                return true;
                            sol[nX1][nY1] = -1;
                        }
                    }
        }
        return false;
    }
    boolean isValid(int x,int y){
        if(x<0 || y<0 || y>=n || x>=n){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KnightTour k=new KnightTour();
        k.startKnightTour();
    }

}
