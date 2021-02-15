package com.company.Tress;

public class BinaryIndexTree {
    int max;
    int[] bit;
    public BinaryIndexTree(int max,int[] nums) {
        this.max = max;
        bit=new int[this.max+1];
        for(int i=1;i<=max;i++) update(i,nums[i-1]);
    }
    void update(int i,int x){
        for(;i<=max;i+=(i&-i))
            bit[i]+=x;
    }
    int sum(int i){
        int ans=0;
        for(;i>0;i-=(i&-i))
            ans+=bit[i];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5};
        BinaryIndexTree bit=new BinaryIndexTree(3,nums);
        System.out.println(bit.sum(3));
        bit.update(2,2-nums[1]);
        System.out.println(bit.sum(3));
    }

}

