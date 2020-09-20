package com.company;

import java.util.HashMap;

//problem link - https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
public class SlidingWindow{
    HashMap<Integer,Integer> hash=new HashMap<>();
    public void getUnique(int k,int[] arr){
        for(int i=0;i<k;i++){
            int value=hash.getOrDefault(arr[i],0);
            hash.put(arr[i],++value);
        }
        System.out.println(hash.size());
        int last=0;
        for(int i=k;i<arr.length;i++){
            int value=hash.get(arr[last]);
            value--;
            if(value==0)
                hash.remove(arr[last]);
            else
                hash.put(arr[last],value);

            value=hash.getOrDefault(arr[i],0);
            if(value==0)
                hash.put(arr[i],1);
            else
                hash.put(arr[i],value+1);

            System.out.println(hash.size());
            last++;
        }

    }

    public static void main(String[] args) {
        SlidingWindow window=new SlidingWindow();
        int[] arr={1, 2, 1, 3, 4, 2, 3};
        int k=4;
        window.getUnique(k,arr);
    }
}
