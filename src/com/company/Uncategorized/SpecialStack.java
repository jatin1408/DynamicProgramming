package com.company.Uncategorized;

import java.util.*;
public class SpecialStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    int MIN;
    public SpecialStack() {
        stack= new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            MIN=x;
            stack.push(x);
        }
        else if(MIN>x){
            int store=2*x-MIN;
            stack.push(store);
            MIN=x;
        }
        else{
            stack.push(x);
        }
    }

    public void pop() {
        int t=stack.peek();
        if(t<MIN){
            int res=MIN;
            MIN=2*MIN-t;
            stack.pop();

        }
        else{
            stack.pop();
        }
    }

    public int top() {
        int t=stack.peek();
        if(t<MIN){
            int res=MIN;
            int MIN=2*res-t;
            return  res;
        }
        else{
            return  t;
        }
    }

    public int getMin() {
        return  MIN;
    }
}
//TWO STACK SOLUTION
class MinStack {
    Stack<Integer> min = new Stack<>();
    Stack<Integer> stack = new Stack<>();
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */