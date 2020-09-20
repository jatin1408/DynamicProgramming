package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinStepsToReachTargetKnight {
    class Cell{
        int x;
        int y;
        int dis;

        public Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    boolean isValid(int x,int y,int N){
        if(x>=1 && x<=N && y>=1 && y<=N)
            return true;
        return false;
    }

    int minNoOfSteps(int[] knight,int[] target,int N){
        int[] dx={1,-1,-2,2,-1,1,-2,2};
        int[] dy={2,-2,-1,-1,2,-2,1,1};
        Queue<Cell> queue=new LinkedList<>();
        boolean[][] visited=new boolean[N+1][N+1];
        Cell temp=new Cell(knight[0],knight[1],0);
        queue.add(temp);
        visited[knight[0]][knight[1]]=true;
        while (!queue.isEmpty()){
            Cell value=queue.poll();
            if(value.x== target[0] && value.y==target[1])
                return value.dis;
            else{
                for(int i=0;i<8;i++){
                    int x= value.x+dx[i];
                    int y= value.y+dy[i];

                    if(isValid(x,y,N) && !visited[x][y]){
                        visited[x][y]=true;
                        queue.add(new Cell(x,y, value.dis+1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MinStepsToReachTargetKnight m=new MinStepsToReachTargetKnight();
        int N = 30;
        int knightPos[] = { 1, 1 };
        int targetPos[] = { 30, 30 };
        System.out.println(
                m.minNoOfSteps(
                        knightPos, targetPos, N));
    }
}
