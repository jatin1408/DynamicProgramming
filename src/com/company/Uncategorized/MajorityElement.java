package com.company.Uncategorized;

public class MajorityElement {
    int majorityElement(int[] a,int size){
        int check=findCandidate(a,size);
        boolean majority=majority(a,a[check],size);
        return majority?a[check]:-1;


    }
    int findCandidate(int[] arr,int size){
        int index=0,count=1;
        for(int i=1;i<size;i++){
            if(arr[i]==arr[index]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                index=i;
                count=1;
            }
        }
        return index;
    }
    boolean majority(int[] a,int element,int size){
        int count=0;
        for(int i=0;i<size;i++){
            if(a[i]==element){
                count++;
            }
        }
        return count>size/2?true:false;
    }

}
