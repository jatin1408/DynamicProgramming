package com.company.Uncategorized;
import java.util.*;
public class MaxProfitAssigningWork {

        class Pair{
            int diff;
            int profit;

            public Pair(int x,int y){
                this.diff=x;
                this.profit=y;
            }
        }
        public int maxProfitAssignment(int[] diff, int[] profit, int[] workers) {
            int n=diff.length;
            Pair[] jobs=new Pair[n];
            for(int i=0;i<n;i++){
                jobs[i]=new Pair(diff[i],profit[i]);
            }
            Arrays.sort(jobs,(a,b) -> a.diff-b.diff);
            Arrays.sort(workers);
            int i=0,best=0,ans=0;
            for(int worker:workers){
                while(i<n && worker>=jobs[i].diff){
                    best=Math.max(best,jobs[i++].profit);
                }
                ans+=best;
            }
            return ans;
        }
    }


