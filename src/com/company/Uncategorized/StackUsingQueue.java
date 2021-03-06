package com.company.Uncategorized;
import java.util.LinkedList;
import java.util.Queue;
public class StackUsingQueue {
    class MyStack {

        /** Initialize your data structure here. */
        Queue<Integer> q1;
        public MyStack() {
            q1=new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
            for(int i=1;i<q1.size();i++){
                q1.add(q1.remove());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.poll();
        }

        /** Get the top element. */
        public int top() {
            return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_
 *
 *
 *  = obj.empty();
 */
}
