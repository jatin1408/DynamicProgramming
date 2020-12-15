package com.company;

public class PartitionArray {

    boolean canBePartitioned(int[] arr,int start,int sum,int targetSum, int n,Boolean[][] t){
        if(start>=n){
            return false;
        }
        if(targetSum==sum)
            return true;
        if(targetSum<sum)
            return false;

        if(t[start][sum]!=null){
            return t[start][sum];
        }


            boolean found=
                    canBePartitioned(arr,start+1,sum+arr[start],targetSum,n,t)
                                                ||
                            canBePartitioned(arr,start+1,sum,targetSum,n,t);



        return t[start][sum]=found;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{15,5,20,10,35,15,10};
        PartitionArray p=new PartitionArray();
        int sum=0;
        for(int obj:arr)
                sum+=obj;
        if(sum%2!=0){
            System.out.println(false);
        }
        else {
            Boolean[][] t=new Boolean[arr.length+1][sum/2];

        System.out.println(p.canBePartitioned(arr,0,0,sum/2,arr.length,t));
    }}
}
