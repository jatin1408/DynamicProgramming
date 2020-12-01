package com.company.Backtracking;
import java.util.*;
public class Permutation {

        public List<List<Integer>> permute(int[] nums) {

            HashSet<List<Integer>> list=new HashSet<>();
            if(nums.length==0){
                List<List<Integer>> l=new ArrayList<>();
                l.add(new ArrayList());
                return l;
            }
            ArrayList<Integer> a=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                a.add(nums[i]);
            }
            backTrack(a,list,0,nums.length-1);
            List<List<Integer>> l=new ArrayList<>(list);
            return l;
        }
        public void backTrack(ArrayList<Integer> nums,HashSet<List<Integer>> list,int l,int r){
            if(l==r){
                list.add(new ArrayList(nums));
            }
            else{
                for(int i=l;i<=r;i++){
                    swap(nums,l,i);
                    backTrack(nums,list,l+1,r);
                    swap(nums,l,i);
                }
            }

        }
        public void swap(ArrayList<Integer> arr,int i,int j){
            Collections.swap(arr, i, j);
        }
    }
