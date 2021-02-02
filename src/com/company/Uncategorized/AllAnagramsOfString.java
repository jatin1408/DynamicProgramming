package com.company.Uncategorized;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramsOfString {


        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int l = 0, r = 0;
            int[] hash = new int[26];
            for (int i = 0; i < p.length(); i++)
                hash[p.charAt(i) - 'a'] += 1;
            while (r < s.length()) {
                if (hash[s.charAt(r) - 'a'] >= 1) {
                    //System.out.println(s.charAt(r));
                    hash[s.charAt(r++) - 'a']--;
                    if (r - l == p.length())
                        result.add(l);
                } else if (r == l) {
                    System.out.println(s.charAt(r));
                    r++;
                    l++;
                } else {
                    //System.out.println(s.charAt(l));
                    hash[s.charAt(l++) - 'a']++;
                }
           /* for(Integer obj:hash){
                System.out.print(obj+" ");
            }
            System.out.println();*/
            }

            return result;
        }


        public static void main(String[] args) {
            String sb = "acaacbpzabacagh";
            String p = "aabc";
            findAnagrams(sb, p);
        }
    }

