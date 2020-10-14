package com.company;

import java.util.Arrays;

public class LongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestChain l=new LongestChain();
        System.out.println(l.findLongestChain(new int[][]{{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }));
    }
}
