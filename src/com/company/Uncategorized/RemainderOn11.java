package com.company.Uncategorized;

public class RemainderOn11 {
     int xmod11(String x)
    {

        int len = x.length();

        int num, rem = 0;


        for (int i = 0; i < len; i++) {
            num = rem * 10 + (x.charAt(i) - '0');
            rem = num % 11;
        }

        return rem;
    }
}
