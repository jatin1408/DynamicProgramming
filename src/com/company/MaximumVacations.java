package com.company;

import java.util.Arrays;

public class MaximumVacations {
    public int maxVacations(int[][] flights,int[][] days){
        int[][] mem=new int[flights.length][days[0].length];
        for(int[] obj:mem){
            Arrays.fill(obj,Integer.MIN_VALUE);
        }
        return dfs(flights,days,mem,0,0);
    }
    public int dfs(int[][] flights,int[][] days,int[][] mem,int week,int currCity){
        if(week==days[0].length)
            return 0;
        if(mem[currCity][week]!=Integer.MIN_VALUE)
            return mem[currCity][week];
        int maxNo=0;
        for(int i=0;i<flights.length;i++){
            if(flights[currCity][i]==1 || currCity==i){
                int vac=days[i][week]+dfs(flights,days,mem,week+1,i);
                maxNo=Math.max(vac,maxNo);
            }
        }
        return mem[currCity][week]=maxNo;
    }

    public static void main(String[] args) {
        MaximumVacations maximumVacations=new MaximumVacations();
        System.out.println(maximumVacations.maxVacations(new int[][]{{0,0,0},{0,0,0},{0,0,0}},new int[][]{{1,1,1},{7,7,7},{7,7,7}}));
    }
}
