package com.company;

class Scratch {
    //Naive approach
    //93 ms
    public static int trap(int[] h) {
        int n=h.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int left=h[i];
            int right=h[i];
            for(int j=i-1;j>=0;j--){
                if(left<h[j]){
                    left=h[j];
                }
            }
            for(int j=i+1;j<n;j++){
                if(right<h[j]){
                    right=h[j];
                }
            }
            //System.out.println(left);
            //System.out.println(right);
            int temp=Math.min(left,right);
            ans+=temp-h[i];
        }
        return ans;
    }
    //o(n) time complexity
    //o(n) space complexity
    //1ms
    public static int trapOptimized(int[] arr){
        int ans=0;
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int max=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                left[i]=max;
            }
            else{
                left[i]=max;
            }
        }
        max=arr[n-1];
        for(int i=n-1;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
                right[i]=max;
            }
            else {
                right[i]=max;
            }
        }
        /*for(Integer obj:left){
            System.out.print(obj+" ");
        }
        System.out.println();
        for(Integer obj:right){
            System.out.print(obj+" ");
        }*/

        for(int i=0;i<n;i++){
            ans+=Math.min(left[i],right[i])-arr[i];
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trapOptimized(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trapOptimized(new int[]{3,0,1,3,0,5}));
    }
}