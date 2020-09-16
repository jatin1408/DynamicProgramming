package com.company;

public class NumberOfWaysToReachDes {
    public int maxWays(int[][] arr){
        int rows=arr.length;
        int cols=arr[0].length;
        int[][] t=new int[rows][cols];
        for(int i=0;i<rows;i++){
            if(arr[i][0]!=-1)
            t[i][0]=1;
            else
                break;
        }
        for(int i=0;i<cols;i++){
            if(arr[0][i]!=-1)
                t[0][i]=1;
            else
                break;
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                t[i][j]=0;
                if(arr[i][j]!=-1)
                    t[i][j]=t[i-1][j]+t[i][j-1];
            }
        }
        return t[rows-1][cols-1];
    }

    public static void main(String[] args) {
        NumberOfWaysToReachDes n=new NumberOfWaysToReachDes();
        int[][] arr={{0,  0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0,  0, 0, 0}};
        System.out.println(n.maxWays(arr));
    }
}
