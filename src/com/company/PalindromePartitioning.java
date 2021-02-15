package com.company;
import java.util.List;
import java.util.ArrayList;
public class PalindromePartitioning {

        List<List<String>> result=new ArrayList<>();
        public List<List<String>> partition(String s) {

            int len=s.length();
            boolean[][] dp=new boolean[len][len];
            List<String> curr=new ArrayList<>();
            dfs(curr,s,0,len,dp);
            return result;
        }
        public void dfs(List<String> curr,String s,int start,int end,boolean[][] dp){
            if(start>=end) result.add(new ArrayList(curr));
            for(int i=start;i<end;i++){
                if(s.charAt(start)==s.charAt(i) && (i-start<=2 || dp[start+1][i-1])){
                    dp[start][i]=true;
                    curr.add(s.substring(start,i+1));
                    dfs(curr,s,i+1,end,dp);
                    curr.remove(curr.size()-1);
                }
            }
        }
    }

