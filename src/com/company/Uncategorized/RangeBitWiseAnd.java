package com.company.Uncategorized;
//https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/593317/Simple-3-line-Java-solution-faster-than-100

public class RangeBitWiseAnd {

        public int rangeBitwiseAnd(int m, int n) {
            while(n>m)
                n = n & n-1;
            return m&n;
        }
    }

