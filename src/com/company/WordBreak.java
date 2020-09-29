package com.company;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class WordBreak{
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashset=new HashSet<>();
        for(String obj:wordDict){
            hashset.add(obj);
        }
        HashMap<String,Boolean> hashmap=new HashMap<>();
        return findWord(s,hashset,hashmap);
    }
    public boolean findWord(String s, HashSet<String> words, HashMap<String,Boolean> hashMap){
        if(s.length()==0){
            return true;
        }
        if(hashMap.containsKey(s)){
            return hashMap.get(s);
        }
        for(int i=1;i<=s.length();i++){
            if(words.contains(s.substring(0,i)) && findWord(s.substring(i,s.length()),words,hashMap)){
                hashMap.put(s.substring(i,s.length()),true);
                return true;
            }
            hashMap.put(s,false);
        }
        return false;
    }
}