package com.company;

public class PalindromeDel {
    public static int getMinDeletion(String s){
        StringBuilder stringBuilder=new StringBuilder(s);
        LCSDP lcsdp=new LCSDP();
        int t=lcsdp.getLongest(s,stringBuilder.reverse().toString());
        return s.length()-t;
    }

    public static void main(String[] args) {
        System.out.println(getMinDeletion("geek"));
    }
}
