package com.company.Uncategorized;

public class QuickSelect {
    public int quickSelect(int[] arr,int low,int high){
        int pivot=arr[high],pat=low;
        for(int i=low;i<=high;i++){
            if(arr[i]>pivot) {
                int temp = arr[i];
                arr[i] = arr[pat];
                arr[pat] = temp;
                pat++;
            }
        }
        int temp=arr[high];
        arr[high]=arr[pat];
        arr[pat]=temp;
        return pat;
    }
    public int findkLargest(int[] arr,int low,int high,int k){
        int pat=quickSelect(arr,low,high);
        if(pat==k-1) return arr[pat];
        else if (pat > k - 1) {
            return findkLargest(arr,low,pat-1,k);
        }
        return findkLargest(arr,pat+1,high,k);
    }

    public static void main(String[] args) {
        QuickSelect select=new QuickSelect();
        int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };

        System.out.println( select.findkLargest(array,0,array.length-1,2));
        for(int val:array) System.out.print(val+" ");
    }
}
