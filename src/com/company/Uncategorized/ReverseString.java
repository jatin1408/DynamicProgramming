package com.company.Uncategorized;

import java.util.Arrays;

//https://drive.google.com/file/d/1iQ51c-fwnDa75nNhw0_2NPPb3ahWVTRY/view?usp=sharing
public class ReverseString {
    public String reverse(String str){

        int n=str.length();
        char[] arr=new char[n];
        int l=0;
        for(int i=n-1;i>=0;i--){
            if(Character.isLetter(str.charAt(i))){
                if(!Character.isLetter(str.charAt(l))){
                    arr[l]= str.charAt(l++);
                    arr[l++]=str.charAt(i);
                }
                else {
                   arr[l++]=str.charAt(i);
                }
            }
            else {
                arr[i]=str.charAt(i);
            }

        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String a="Ab,c,de!$";
        ReverseString string=new ReverseString();
        System.out.println(string.reverse(a));
    }
}
