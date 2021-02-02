package com.company.Uncategorized;

public class ConcatenationOfConsecutiveBinaryNumbers {

        public int concatenatedBinary(int n) {
            long res=1;
            for(int i=2;i<=n;i++){
                int length=getBinaryLength(i);
                res=(((res<<length)%1000000007)+i)%1000000007;
            }
            return (int)res;
        }
        public int getBinaryLength(int n)
        {
            int length = 0;
            while (n > 0)
            {
                length += 1;
                n /= 2;
            }
            return length;
        }
    }

