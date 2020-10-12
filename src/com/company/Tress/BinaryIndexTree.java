package com.company.Tress;

public class BinaryIndexTree {

    public int getSum(int[] arr,int index){
        int sum=0;
        index=index+1;
        while (index>0){
            sum+=arr[index];
            index=getParent(index);
        }
        return sum;
    }
    public int getParent(int index){
        return index & index-1;
    }
    public void updateValues(int[] arr,int val,int index){
        while (index<arr.length){
            arr[index]+=val;
            index=getNext(index);
        }
    }
    public int getNext(int index) {
        return index+(index&-index);
    }
    public int[] construct(int[] input){
        int[] arr=new int[input.length+1];
        for(int i=1;i<=input.length;i++){
            updateValues(arr,input[i-1],i);
        }
        return arr;
    }

    public static void main(String[] args) {
        BinaryIndexTree b=new BinaryIndexTree();
        int[] arr=b.construct(new int[]{1, 2, 3, 6,8});
        System.out.println(b.getSum(arr,4));
        System.out.println(b.getSum(arr,1));
    }
}
