package com.company.Uncategorized;

import java.util.Iterator;
import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
public class KSortedArray {
    public static void main(String[] args) {
        int[] arr={2, 6, 3, 12, 56, 8};
        int k=3;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k+1;i++){
            pq.add(arr[i]);
        }
        int index=0;
        for(int i=k+1;i<arr.length;i++){
            arr[index++]=pq.poll();
            pq.add(arr[i]);
        }
        Iterator<Integer> it=pq.iterator();
        while (it.hasNext()){
            arr[index++]=pq.poll();
        }
        for(Integer obj:arr){
            System.out.print(obj+" ");
        }
    }


}
