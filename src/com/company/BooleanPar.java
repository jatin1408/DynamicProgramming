package com.company;

import java.util.HashMap;

public class BooleanPar {
    HashMap<String,Integer> hashMap=new HashMap<>();
    int solve(char[] s,int i,int j,boolean exp){
        int ans=0;
        if(i>j){
            return 0;
        }
        if(i==j){
            if(exp){
                return s[i]=='T'?1:0;
            }
            return s[i]=='F'?1:0;
        }
        for(int k=i+1;k<j;k+=2){
            int lf=solve(s,i,k-1,false);
            int lt=solve(s,i,k-1,true);
            int rf=solve(s,k+1,j,false);
            int rt=solve(s,k+1,j,true);
            if(s[k]=='&'){
                if(exp){
                    ans+=lt*rt;
                }
                else{
                    ans+=lf*rf+lt*rf+rt*lf;
                }
            }
            else if(s[k]=='^'){
                if(exp){
                    ans+=lf*rt+lt*rf;
                }
                else{
                    ans+=lt*rt+lf*rf;
                }
            }
            else if(s[k]=='|'){
                if(exp){
                    ans+=lf*rt+rf*lt+lt*rt;
                }
                else{
                    ans+=lf*rf;
                }
            }
        }
        return ans;
    }
    int solveMemoize(char[] s,int i,int j,boolean exp){
        int ans=0;
        if(i>j){
            return 0;
        }
        if(i==j){
            if(exp){
                return s[i]=='T'?1:0;
            }
            return s[i]=='F'?1:0;
        }

        String temp="";
        temp+=Integer.toString(i);
        temp+=" ";
        temp+=Integer.toString(j);
        temp+=" ";
        temp+=Boolean.toString(exp);
        if(hashMap.containsKey(temp)){
            return hashMap.get(temp);
        }
        for(int k=i+1;k<=j-1;k+=2){

            int lf=solveMemoize(s,i,k-1,false);
            int lt=solveMemoize(s,i,k-1,true);
            int rf=solveMemoize(s,k+1,j,false);
            int rt=solveMemoize(s,k+1,j,true);
            if(s[k]=='&'){
                if(exp){
                    ans+=(lt*rt);
                }
                else{
                    ans+=(lf*rf)+(lt*rf)+(rt*lf);
                }
            }
            else if(s[k]=='^'){
                if(exp){
                    ans+=(lf*rt)+(lt*rf);
                }
                else{
                    ans+=(lt*rt)+(lf*rf);
                }
            }
            else if(s[k]=='|'){
                if(exp){
                    ans+=(lf*rt)+(rf*lt)+(lt*rt);
                }
                else{
                    ans+=(lf*rf);
                }
            }
        }
        hashMap.put(temp,ans);
        return ans;
    }

    public static void main(String[] args) {
        BooleanPar b=new BooleanPar();
        String s="T^T^T^F|F&F^F|T^F^T";
        System.out.println(b.solve(s.toCharArray(),0,s.length()-1,true));
        System.out.println(b.solveMemoize(s.toCharArray(),0,s.length()-1,true)%1003);
    }

}
