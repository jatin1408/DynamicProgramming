package com.company.BinarySearch;

public class NextGreaterElement {
    public char nextGreater(char[] arr,char target){
        int start=0;
        int end=arr.length-1;
        if(target>=arr[end]){
            return arr[0];
        }
        int res=Integer.MAX_VALUE;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                res = Math.min(res, arr[mid]);
                end = mid - 1;
            }
            else
                start=mid+1;

        }
        return (char)res;
    }

    public static void main(String[] args) {
        char[] arr={'b','c','f','j'};
        char target='j';
        NextGreaterElement n=new NextGreaterElement();
        System.out.println(n.nextGreater(arr,target));
    }
}
