package com.company;
import java.util.HashMap;
public class InterleavingStrings {

        HashMap<String,Boolean> hashMap=new HashMap<>();
        public boolean isInterleave(String s1, String s2, String s3) {
            int lena=s1.length();
            int lenb=s2.length();
            int lenc=s3.length();
            if(lenc!=lena+lenb){
                return false;
            }
            return helper(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),lena,lenb,lenc,0,0,0);
        }
        public boolean helper(char[] s1,char[] s2,char[] s3,int a,int b,int c,int p1,int p2,int p3){
            if(p3==c){
                return p1==a && p2==b?true:false;
            }
            String key=p1+"*"+p2+"*"+p3;
            if(hashMap.containsKey(key)){
                return hashMap.get(key);
            }
            if(p1==a){
                boolean res=s2[p2]!=s3[p3]?false:helper(s1,s2,s3,a,b,c,p1,p2+1,p3+1);
                hashMap.put(key,res);
                return res;
            }
            if(p2==b){
                boolean res=s1[p1]!=s3[p3]?false:helper(s1,s2,s3,a,b,c,p1+1,p2,p3+1);
                hashMap.put(key,res);
                return res;
            }
            boolean one=false;
            boolean two=false;
            if(s1[p1]==s3[p3]){
                one=helper(s1,s2,s3,a,b,c,p1+1,p2,p3+1);
            }
            if(s2[p2]==s3[p3]){
                two=helper(s1,s2,s3,a,b,c,p1,p2+1,p3+1);
            }
            boolean res=one||two;
            hashMap.put(key,res);
            return res;
        }
    }

