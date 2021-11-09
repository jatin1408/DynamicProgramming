package com.company;
class LIS {
    public static int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        return lis(nums,n);
    }
    public static int lis(int[] nums,int n){
        int[] output=new int[n];
        output[0]=1;
        int ans=0;
        for(int i=1;i<n;i++){
            output[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]>=nums[i]){
                    continue;
                }
                int temp=output[j]+1;
                if(temp>=3) ans++;
                if(temp>output[i]){
                    output[i]=temp;
                }
            }
        }

        return ans;
    }
    public static int lds(int[] nums,int n){
        int lds[] = new int[n];
        int i, j;
        int ans=0;

        for (i = 0; i < n; i++)
            lds[i] = 1;


        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (nums[i] < nums[j]) {
                    int temp=lds[j]+1;
                    if(temp>lds[i])
                    lds[i] = lds[j] + 1;
                    if(lds[i]>=3) ans++;
                }



        return ans;
    }

    public static void main(String[] args) {
        int[] arr={5,2,3,1,4};
        int n=5;
        int lis=lis(arr,n);
        int lds=lds(arr,n);
        System.out.println(lis+lds);

    }
}