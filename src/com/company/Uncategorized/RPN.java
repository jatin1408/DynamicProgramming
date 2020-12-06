package com.company.Uncategorized;
import java.util.Stack;
public class RPN {

        public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            int ans=0;
            if(tokens.length==1){
                return Integer.parseInt(tokens[0]);
            }
            for(String x:tokens){
                char[] temp=x.toCharArray();
                if(temp.length==1 && !Character.isDigit(temp[0])){
                    int res=0;
                    char op=temp[0];
                    int a=stack.pop();
                    int b=stack.pop();
                    if(op=='/'){
                        res=b/a;
                    }
                    else if(op=='-'){
                        res=b-a;
                    }
                    else if(op=='+'){
                        res=b+a;
                    }
                    else if(op=='*'){
                        res=b*a;
                    }
                    ans=res;
                    stack.push(res);
                }
                else{
                    int u=Integer.parseInt(x);
                    stack.push(u);
                }
            }
            return ans;
        }
    }

