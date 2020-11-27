package com.company.Strings;
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {

        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int len = temp.length();
        int[] lps = new int[len];
        fill(temp, len, lps);
        return new StringBuilder(s.substring(lps[len - 1])).reverse().toString() + s;

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
}
