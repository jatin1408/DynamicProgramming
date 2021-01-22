package com.company.Uncategorized;

import java.util.Arrays;
import java.util.Stack;

public class SortAStack {
    public void sortStack(Stack<Integer> stack){
        if(stack.empty()) return;
        int temp=stack.pop();
        sortStack(stack);
        sortInserted(stack,temp);

    }
    public void sortInserted(Stack<Integer> stack,int popped){
        if(stack.empty() || popped>stack.peek()) stack.push(popped);
        else{
            int temp=stack.pop();
            sortInserted(stack,popped);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        SortAStack stack=new SortAStack();
        Stack<Integer> ds=new Stack<>();
        int[] arr={9, 4
                , 1, 7, 3, 26, 24, 5};
       for(int obj:arr){
           ds.add(obj);
       }
       stack.sortStack(ds);
       ds.forEach(System.out::println);
    }
}
