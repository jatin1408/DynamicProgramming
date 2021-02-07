package com.company.Uncategorized;

public class RotateArray {
        public void reverse(int[] a,int i,int j){
            int li=i;
            int ri=j;
            while (li<ri){
                int temp=a[li];
                a[li]=a[ri];
                a[ri]=temp;
                li++;
                ri--;

            }

        }
        public  void rotate(int[] nums,int k){
            k%=nums.length;
            if(k==0) return;
            if(k<0) k+=nums.length;
            reverse(nums,0,nums.length-k-1);
            reverse(nums,nums.length-k,nums.length-1);
            reverse(nums,0,nums.length-1);
        }
    }

