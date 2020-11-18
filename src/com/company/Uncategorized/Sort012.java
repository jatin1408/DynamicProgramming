package com.company.Uncategorized;

public class Sort012 {
    public int[] sortArray(int[] arr,int n){
        int l=0,r=n-1,m=0;
        while (m<=r){
            if(arr[m]==0){
                    swap(arr,l,m);
                    m++;
                    l++;
            }
            else if(arr[m]==1)
                m++;

            else
                swap(arr,m,r);
                r--;

        }
        return arr;
    }
    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        Sort012 s=new Sort012();
        int[] arr=s.sortArray(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1},12);
        for(Integer obj:arr){
            System.out.print(obj+" ");
        }
        System.out.println();
    }
}
