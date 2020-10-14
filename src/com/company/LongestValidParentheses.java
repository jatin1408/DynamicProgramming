package com.company;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int valid=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else{
                stack.pop();
                if(!stack.isEmpty())
                    valid=Math.max(valid,i-stack.peek());
                else
                    stack.push(i);
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        LongestValidParentheses lp=new LongestValidParentheses();
        System.out.println(lp.longestValidParentheses("(()))(()()"));

    }
}
