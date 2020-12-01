package com.company;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ConcatenatedWords {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res=new ArrayList<>();
            Arrays.sort(words,(a,b)-> a.length()-b.length());
            HashSet<String> set=new HashSet<>();
            for(int i=0;i<words.length;i++){
                if(helper(words[i],set,0,new Boolean[words[i].length()])){
                    res.add(words[i]);
                }
                set.add(words[i]);
            }
            return res;
        }
        public boolean helper(String s,HashSet<String> set,int start,Boolean[] mem){
            if(set.size()==0){
                return false;
            }
            if(s.length()==start){
                return true;
            }
            if(mem[start]!=null){
                return mem[start];
            }
            for(int i=start+1;i<=s.length();i++){
                if(set.contains(s.substring(start,i)) && helper(s,set,i,mem)){
                    mem[start]=true;
                    return true;
                }
            }
            mem[start]=false;
            return false;
        }
    }

