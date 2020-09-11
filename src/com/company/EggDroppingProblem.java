package com.company;

import java.util.Arrays;

public class EggDroppingProblem {
    int[][] t=new int[101][100001];
    public int eggDroppingRecursive(int e,int f){
        if(f==0 || f==1)
            return f;
        if(e==1)
            return f;
        if(t[e][f]!=-1){
            return t[e][f];
        }
        int min=Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int temp=1+Math.max(eggDroppingRecursive(e-1,k-1),eggDroppingRecursive(e,f-k));
            min=Math.min(temp,min);
        }
        return t[e][f]=min;
    }

    public static void main(String[] args) {

        EggDroppingProblem eggDroppingProblem=new EggDroppingProblem();
        for(int[] obj: eggDroppingProblem.t){
            Arrays.fill(obj,-1);
        }
        System.out.println(eggDroppingProblem.eggDroppingRecursive(2,10));
    }
}
