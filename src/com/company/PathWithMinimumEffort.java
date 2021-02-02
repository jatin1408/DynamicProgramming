package com.company;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
public class PathWithMinimumEffort {

        public int minimumEffortPath(int[][] heights) {
            int rows=heights.length;
            int cols=heights[0].length;
            int[][] dist=new int[rows][cols];
            for(int[] arr:dist) Arrays.fill(arr,Integer.MAX_VALUE);
            PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
            pq.add(new int[]{0,0,0});
            int[] dir={0,1,0,-1,0};
            while(!pq.isEmpty()){
                int[] popped=pq.remove();
                int diff=popped[0],r=popped[1],c=popped[2];
                if(dist[r][c]<diff) continue;
                if(r==rows-1 && c==cols-1) return diff;
                for(int i=0;i<4;i++){
                    int nr=r+dir[i],nc=c+dir[i+1];
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols) {
                        int newDiff=Math.max(diff,Math.abs(heights[r][c]-heights[nr][nc]));
                        if(dist[nr][nc]>newDiff){
                            dist[nr][nc]=newDiff;
                            pq.add(new int[]{newDiff,nr,nc});

                        }

                    }
                }
            }
            return 0;


        }
    }
