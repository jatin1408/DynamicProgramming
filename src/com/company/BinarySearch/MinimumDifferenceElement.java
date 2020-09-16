package com.company.BinarySearch;

public class MinimumDifferenceElement {
    int minElement(int[] arr,int key){
        FloorOfSortedArray f=new FloorOfSortedArray();
        int floor=f.binarySearch(arr,key);
        int ceil=f.binarySearchCeil(arr,key);
        return Math.min(key-floor,Math.abs(ceil-key));
    }

    public static void main(String[] args) {
        int[] arr={4,6,10};
        MinimumDifferenceElement m=new MinimumDifferenceElement();
        System.out.println(m.minElement(arr,7));
    }
}
