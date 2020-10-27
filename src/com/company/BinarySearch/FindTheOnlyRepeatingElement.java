package com.company.BinarySearch;
//https://www.geeksforgeeks.org/find-repeating-element-sorted-array-size-n/
public class FindTheOnlyRepeatingElement {
    public int findRepeatingElement(int[] arr){
        int l=0;
        int r=arr.length-1;
        while (l<r){
            int mid=(l+r)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            else if(arr[mid]!=arr[mid-1] && mid%2==1){
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return arr[l];
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,4,4};
        FindTheOnlyRepeatingElement f=new FindTheOnlyRepeatingElement();
        System.out.println(f.findRepeatingElement(arr));
    }

}
