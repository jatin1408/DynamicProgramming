package com.company.Uncategorized;
import java.util.Arrays;
public class MinimumPlatformsRequired {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0;
        int plat=1,result=1;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                plat++;
                i++;
            }
            else if(arr[i]>dep[j]){
                plat--;
                j++;
            }
            if(plat>result){
                result=plat;
            }
        }
        return result;
    }

}
