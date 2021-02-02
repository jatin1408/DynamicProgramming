package com.company;
import java.util.ArrayList;
import java.util.List;
public class SubsetGenerationUsingBitManipulation {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results=new ArrayList<>();
            int size=nums.length;
            int loop=(1<<size);
            for(int i=0;i<loop;i++){
                List<Integer> temp=new ArrayList<>();
                for(int bit=0;bit<size;bit++){
                    if((i & (1 << bit))!=0){
                        temp.add(nums[bit]);
                    }
                }
                results.add(temp);
            }
            return results;
        }
    }

