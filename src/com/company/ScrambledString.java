package com.company;

import java.util.*;

public class ScrambledString {
    Map<String,Boolean> hashMap=new HashMap<>();
    public boolean scrambledStrings(String a,String b){
        if(a.compareTo(b)==0){
            return true;
        }
        if(a.length()<=1)
            return false;
        String temp=a;
        temp+="|";
        temp+=b;
        if(hashMap.containsKey(temp)){
            return hashMap.get(temp);
        }
        int n=a.length();
        boolean flag=false;
        for(int i=1;i<n;i++){
            if(scrambledStrings(a.substring(0,i),b.substring(n-i,n)) && scrambledStrings(a.substring(i,n),b.substring(0,n-i))){
                flag=true;
            }
            else if(scrambledStrings(a.substring(0,i),b.substring(0,i)) && scrambledStrings(a.substring(i,n),b.substring(i,n))){
                flag=true;
            }

        }
        hashMap.put(temp,flag);
        return flag;
    }

    public static void main(String[] args) {
        ScrambledString s=new ScrambledString();
        String a="coder";
        String b="ocred";

        System.out.println(s.scrambledStrings(a,b));

    }
}
