package com.company.Uncategorized;
//Weird Solution Taken from leetcode
//https://leetcode.com/problems/single-number/
//Well Explained-https://leetcode.com/problems/single-number/discuss/43201/Easy-Java-solution-(tell-you-why-using-bitwise-XOR)
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
