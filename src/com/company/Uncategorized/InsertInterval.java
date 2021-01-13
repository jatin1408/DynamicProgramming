package com.company.Uncategorized;
import java.util.ArrayList;
public class InsertInterval {

        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<int[]> res=new ArrayList<>();
            int len=intervals.length;
            int start=newInterval[0];
            int end=newInterval[1];
            int i=0;
            while(i<len && intervals[i][1]<start){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
                i++;
            }
            while(i<len && intervals[i][0]<=end){
                start=Math.min(start,intervals[i][0]);
                end=Math.max(end,intervals[i][1]);
                i++;
            }
            res.add(new int[]{start,end});
            while(i<len){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
                i++;
            }
            len=res.size();
            int[][] result=new int[len][2];
            for( i=0;i<len;i++){
                result[i][0]=res.get(i)[0];
                result[i][1]=res.get(i)[1];
            }
            return result;
        }
    }

