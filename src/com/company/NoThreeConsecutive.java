package com.company;



import java.util.Arrays;
import java.util.List;

class NoThreeConsecutive {
    public static String noThreeConsecutive(String str){
        char[] arr=str.toCharArray();
        int[][] right=new int[arr.length][2];
        int a=0;
        int b=0;
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch=='a'){
                a+=1;
                b=0;
            }
            else if(ch=='b') {
                b+=1;
                a=0;
            }
            else {
                right[i][0]=a;
                right[i][1]=b;
                a=0;
                b=0;
            }
        }

        a=0;
        b=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='?'){
                int prevA=a;
                int forwardA=right[i][0];

                int nextA=i!= str.length()-1 && arr[i+1]=='?' ? right[i+1][0]:0;
                int nextB=i!= str.length()-1 && arr[i+1]=='?' ? right[i+1][1]:0;
                if(nextA==2) {
                    arr[i]='a';
                    a+=1;
                    b=0;
                    continue;
                }
                if(nextB==2){
                    arr[i]='b';
                    b+=1;
                    a=0;
                    continue;
                }
                if(prevA+forwardA<2){
                    arr[i]='a';
                    a+=1;
                    b=0;
                }
                else {
                    arr[i]='b';
                    a=0;
                    b+=1;
                }
            }
            else if(ch=='a') {
                a+=1;
                b=0;
            }
            else {
                b+=1;
                a=0;
            }
        }

        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        List<String> ls= Arrays.asList(new String[]{ "?",
                "??",
                "???",
                "a?",
                "a??",
                "a???",
                "b?",
                "b??",
                "b???",
                "a?a",
                "a?b",
                "b?a",
                "b?b",
                "a??a",
                "a??b",
                "b??a",
                "b??b",
                "aa?",
                "ba?",
                "a?bb",
                "?bb?",
                "?a",
                "?aa",
                "??aa",
                "???aa",
                "????aa",
                "?ab",
                "??ab",
                "???ab",
                "????ab",
                "a?b?aa",
                "ab???bb?",
                "aa?bb",
                "a?b?a?bb",
                "?a?b?aa"});
       for(String ele:ls) System.out.println(noThreeConsecutive(ele));
        //System.out.println(noThreeConsecutive("ab???bb?"));
//        System.out.println(noThreeConsecutive("??abb"));
//        System.out.println(noThreeConsecutive("a?b?aa"));
//        System.out.println(noThreeConsecutive("a?bb"));
//        System.out.println(noThreeConsecutive("aa??aba???ba"));
//        System.out.println(noThreeConsecutive(""));
    }
}