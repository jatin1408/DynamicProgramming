package com.company.BinarySearch;
//Painter Partition problem can be solved using the same logic
public class BookAllocation {
    int minBookAllocation(int[] arr,int k){
        int n=arr.length;
        int start=0;
        int end=getSum(arr);
        int res=Integer.MAX_VALUE;
        while (start<=end){
            int m=start+(end-start)/2;
            if(isValid(arr,k,m,n)){
                res=Math.min(res,m);
                end=m-1;
            }
            else {
                start=m+1;
            }
        }
        return res;
    }
    int getSum(int[] arr){
        int sum=0;
        for(Integer obj:arr){
            sum+=obj;
        }
        return sum;
    }
    boolean isValid(int[] arr,int k,int max,int n){
        int sum=0;
        int student=1;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>max) {
                student++;
                sum=arr[i];
            }
            if(student>k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        BookAllocation b=new BookAllocation();
        int k=5;
        System.out.println(b.minBookAllocation(arr,k));
    }
}
