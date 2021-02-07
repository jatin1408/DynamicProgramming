package com.company.Uncategorized;
import java.util.Stack;
public class MinimumRemovetoMakeValidParentheses {

        public static String minRemoveToMakeValid(String s) {
            Stack<String> stack = new Stack<>();
            StringBuilder res=new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                String ch = Character.toString(s.charAt(i));
                if (ch.equals(")")) {
                    if (stack.isEmpty()) continue;
                    else {
                        String top = stack.pop();
                        StringBuilder sb = new StringBuilder();
                        boolean g = false;
                        while (!top.equals("(")) {
                            sb.insert(0, top);
                            if (stack.isEmpty()) {
                                g = true;
                                break;
                            }
                            top = stack.pop();
                        }


                        if(!g) {
                            sb.insert(0, '(');
                            sb.append(')');

                        }
                        stack.push(sb.toString());
                    }
                } else stack.push(ch);
            }
            while (!stack.isEmpty()){
                String str=stack.pop();
                if(!(str.equals(")") || str.equals("(")))
                    res.insert(0,str);

            }

            return res.toString();
        }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
    }

