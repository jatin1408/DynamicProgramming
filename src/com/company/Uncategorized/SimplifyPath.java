package com.company.Uncategorized;
import java.util.HashSet;
import java.util.Deque;
import java.util.Set;
import java.util.Arrays;
import java.util.LinkedList;
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack=new LinkedList<>();
        Set<String> hash=new HashSet<>(Arrays.asList("..",".",""));
        for(String str:path.split("/")){
            if(str.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!hash.contains(str)) stack.push(str);
        }

        if(stack.size()==0) return "/";
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
