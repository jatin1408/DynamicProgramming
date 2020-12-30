package com.company.Uncategorized;

public class SETBITS {
    static int setBits(int N){
        // code here
        int count=0;
        while(N>0){
            N&=N-1;
            count++;
        }
        return count;
    }
}
