package com.company;

public class MaximumAdjacentSum {
    int maximumSum(int[] arr) {
        int incl = arr[0];
        int excl = 0;
        for (int i = 1; i < arr.length; i++) {
            int old = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = old;
        }
        return incl;
    }

    public static void main(String[] args) {
        MaximumAdjacentSum m = new MaximumAdjacentSum();
        System.out.println(m.maximumSum(new int[]{5,5,10,100,10,5}));
    }
}
