package com.company.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public void combinationSum(int[] arr,int target){
        Arrays.sort(arr);
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> f=new ArrayList<>();
        dfs(arr,temp,f,0,target);
    }
    public void dfs(int[] arr,List<Integer> temp,List<List<Integer>> f,int start,int target){
        if(target==0){
            f.add(temp);
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(arr[i]>target){
                break;
            }
            temp.add(arr[i]);
            dfs(arr,temp,f,i,target-arr[i]);
            temp.remove(temp.size()-1);
        }
    }
}
