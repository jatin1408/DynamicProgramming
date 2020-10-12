package com.company;

public class InversionCount {
    public int inverse(int[] arr,int left,int right){
        if(right>left){
            int mid=(right+left)/2;
            int leftCount=inverse(arr,left,mid);
            int rightCount=inverse(arr,mid+1,right);
            int sum=merge(arr,left,right,mid+1);
            return leftCount+rightCount+sum;
        }
        return 0;
    }
    public int merge(int[] arr,int left,int right,int mid){
            int i=left,j=mid,k=0,count=0;
            int[] temp=new int[right-left+1];
            while (i<=mid && j<=right){
                if(arr[i]>arr[j]){
                    temp[k++]=arr[j++];
                    count+=mid-i;
                }
                else {
                    temp[k++]=arr[i++];
                }
            }
            while (i<mid){
                temp[k++]=arr[i++];
            }
            while (j<=right){
                temp[k++]=arr[j++];
            }
            for(i=left,k=0;i<=right;i++,k++){
                arr[i]=temp[k];
            }
            return count;
    }

    public static void main(String[] args) {
        int[] arr={8, 4, 2, 1};
        InversionCount i=new InversionCount();
        System.out.println(i.inverse(arr,0,arr.length-1));
    }
}
