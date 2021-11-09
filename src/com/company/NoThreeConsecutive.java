package com.company;


class NoThreeConsecutive {
    public static String noThreeConsecutive(String str){
        char[] arr=str.toCharArray();
        int[] right=new int[arr.length];
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
                right[i]=a;
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
                int forwardA=right[i];
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
        System.out.println(noThreeConsecutive("a?bb??aabb"));
        System.out.println(noThreeConsecutive("??abb"));
        System.out.println(noThreeConsecutive("a?b?aa"));
        System.out.println(noThreeConsecutive("a?bb"));
        System.out.println(noThreeConsecutive("aa??aba???ba"));
    }
}