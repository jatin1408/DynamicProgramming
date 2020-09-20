package com.company;


import java.util.*;

//Solution Taken from LeetCode
public class WordLadder {
    static class Pair{
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int getLevel(List<String> words,String beginWord,String endWord){
        int l=beginWord.length();
        Map<String,List<String>> map=new HashMap<>();
        words.forEach(word->{
            for(int i=0;i<l;i++){
                String newWord=word.substring(0,i)+'*'+word.substring(i+1,l);
                List<String> list=map.getOrDefault(newWord,new ArrayList<>());
                list.add(word);
                map.put(newWord,list);
            }
        });
        Queue<Pair> q=new LinkedList();
        Map<String,Boolean> visited=new HashMap<>();
        visited.put(beginWord,true);
        q.add(new Pair(beginWord,1));
        while (!q.isEmpty()){
            Pair p=q.remove();
            int level=p.value;
            String key=p.key;
            for(int i=0;i<l;i++){
                String newWord=key.substring(0,i)+"*"+key.substring(i+1,l);
                for(String obj:map.getOrDefault(newWord,new ArrayList<>())){
                    if(obj.equals(endWord)){
                        return level+1;
                    }
                    if(!visited.containsKey(obj)){
                        q.add(new Pair(obj,level+1));
                        visited.put(obj,true);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord="hit";
        String endWord="cog";
        WordLadder wordLadder=new WordLadder();
        System.out.println(wordLadder.getLevel(wordList,beginWord,endWord));
    }
}
