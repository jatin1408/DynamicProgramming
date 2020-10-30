package com.company.Uncategorized;

import java.util.Stack;

public class DecodeStrings {
    public String decodeString(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }
        Stack<String> stack=new Stack<>();
        Stack<Integer> numberStack=new Stack<>();
        StringBuilder res=new StringBuilder();
        int idx=0;
        while(idx<s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int num=0;
                while(Character.isDigit(s.charAt(idx))){
                    num=num*10+(s.charAt(idx)-'0');
                    idx++;
                }
                numberStack.push(num);
            }
            else if(s.charAt(idx)=='['){
                stack.push(res.toString());
                res=new StringBuilder("");
                idx++;
            }
            else if(s.charAt(idx)==']'){
                StringBuilder temp = new
                        StringBuilder(stack.pop());
                int repeatTimes = numberStack.pop();
                System.out.println(temp);
                System.out.println(repeatTimes);
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                System.out.println(temp);
                res = temp;
                idx++;

            }
            else{
                res.append(s.charAt(idx++));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeStrings d=new DecodeStrings();
        d.decodeString("2abc3[cd]xyz");

    }
}
