package com.company;
//https://www.geeksforgeeks.org/count-of-ways-to-travel-a-cyclic-path-in-n-steps-in-a-triangular-pyramid/
public class NoOfWaysToReachDestination {

    static int res=0;
    static int[][] path = new int[4][4];
    public static void NoOfWays() {

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (i != j)
                    path[i][j] = 1;


            }


    public static void dfs(int source,int n){
        if(n<=0) return;
        if(n==1 && path[source][0]==1){
            res+=1;
            return;
        }
        if(n==1 && path[source][0]!=1) return;
        for(int i=0;i<4;i++){
            if(path[source][i]==1){
                dfs(i,n-1);
            }
        }
    }

    public static void main(String[] args) {


        NoOfWays();

        dfs(0,2);
        System.out.println(res);
    }
    }
