package com.company.Strings;

public class KMPALGO {
    public int strStr(String text, String pattern) {
        //KMP ALGORITHIM
        int m = pattern.length();
        int n = text.length();
        if (m == 0 && n == 0)
            return 0;
        if (m == 0)
            return 0;

        if (n == 0)
            return -1;

        int[] lps = new int[m];
        fill(pattern, m, lps);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m)
                return i - j;

            else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -1;
    }

    void fill(String pattern, int m, int lps[]) {
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else
                    len = lps[len - 1];
            }
        }

    }

    public static void main(String[] args) {
        KMPALGO kmpalgo=new KMPALGO();


    }
}
