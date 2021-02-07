package com.company.Uncategorized;
import java.util.List;
import java.util.ArrayList;
public class MajorityElement2
{

        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result=new ArrayList<>();
            int count1=0,count2=0;
            int can1=0,can2=0;
            for(int i=0;i<nums.length;i++){
                int ele=nums[i];
                if(ele==can1){
                    count1++;

                }
                else if(ele==can2) count2++;
                else if(count1==0) {
                    can1=ele;
                    count1+=1;
                }
                else if(count2==0){
                    can2=ele;
                    count2+=1;
                }
                else {
                    count1-=1;
                    count2-=1;
                }
            }
            int c1=count(nums,can1);
            int c2=count(nums,can2);

            if(c1>nums.length/3) result.add(can1);
            if(c2>nums.length/3 && can1!=can2) result.add(can2);
            return result;
        }
        int count(int[] nums,int target){
            int val=0;
            for(Integer obj:nums)
                if(obj==target) val++;

            return val;
        }
    }

