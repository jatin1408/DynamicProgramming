package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Problem Statement-
//https://docs.google.com/document/d/1phyEjtK0Uq71uJWacr3tekO4xb_7yCOo8J3sshxVQhE/edit?usp=sharing
public class LiftProblemBfs {
    static int minSteps(int n,int src,int des,int up,int down){
        Queue<Integer> queue=new LinkedList<>();
        int[] steps=new int[n+1];
        Arrays.fill(steps,-1);
        queue.add(src);
        steps[src]=0;
        while (!queue.isEmpty()){
            int curr=queue.poll();
            if(curr+up<=n && steps[curr+up]==-1){
                steps[curr+up]=steps[curr]+1;
                queue.add(curr+up);
            }
            if(curr-down>0 && steps[curr-down]==-1){
                steps[curr-down]=steps[curr]+1;
                queue.add(curr-down);
            }
        }
        return steps[des];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(5,3,2,1,2));
    }
}
