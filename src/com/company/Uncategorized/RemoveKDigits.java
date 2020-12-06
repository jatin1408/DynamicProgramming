package com.company.Uncategorized;
import java.util.*;
public class RemoveKDigits {

        public String removeKdigits(String num, int k) {
            Stack<Character> stack=new Stack<>();
            if(num.length()==k){
                return "0";
            }
            for(char c:num.toCharArray()){
                while(!stack.isEmpty() && k>0 && stack.peek()>c){
                    stack.pop();
                    k--;
                }
                if(!stack.isEmpty() || c!='0'){
                    stack.push(c);
                }
            }
            while(!stack.isEmpty() && k>0){
                stack.pop();
                k--;
                if(stack.isEmpty()){
                    return "0";
                }
            }
            StringBuilder res=new StringBuilder();
            while(!stack.isEmpty()){
                res.append(stack.pop());
            }
            if(res.length()==0){
                return "0";
            }
            return res.reverse().toString();
        }
    }
