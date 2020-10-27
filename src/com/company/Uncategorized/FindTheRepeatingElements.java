package com.company.Uncategorized;
import java.util.*;
//https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
//https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
public class FindTheRepeatingElements {
    List<Integer> getRepeatedElements(int[] arr){
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[Math.abs(arr[i])]>0){

                arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
            }
            else {
                list.add(Math.abs(arr[i]));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        FindTheRepeatingElements f=new FindTheRepeatingElements();
        List<Integer> list=f.getRepeatedElements(arr);
        for(Integer obj:list){
            System.out.print(obj+" ");
        }
    }
}