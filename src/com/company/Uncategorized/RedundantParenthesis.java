package com.company.Uncategorized;

import java.util.Stack;

public class RedundantParenthesis {
    public static int findRedundant(String s){
        Stack<Character> stack=new Stack<>();
        char[] arr=s.toCharArray();
        int total=0;
        for(int i=0;i<arr.length;i++){
            char ch=s.charAt(i);
            if(ch==')'){
                int t=0;
                char top=stack.pop();
                while (top!='('){
                    t++;
                    top=stack.pop();
                }
                if(t==0){
                    System.out.println(i);
                    total++;
                }
            }
            else {
                stack.push(ch);
            }
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        String str="((a+b)+((c+d)))";
        findRedundant(str);
    }
}
