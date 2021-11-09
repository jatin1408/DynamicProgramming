package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class CompareByLength implements Comparator<String> {
    public int compare(String a,String b){
        return b.length()-a.length();
    };
}
public class TrieLeetCode {
    TrieNode root;
    List<String> allWords=new ArrayList<>();
    /**
     * Initialize your data structure here.
     */
    class TrieNode {
        TrieNode[] links;
        int r = 26;
        boolean isEnd;

        public TrieNode() {
            links = new TrieNode[r];

        }

        boolean isEnd() {
            return isEnd;
        }

        void setEnd() {
            isEnd = true;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        TrieNode getKey(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    }

    public TrieLeetCode() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.getKey(ch);

        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();

    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return null;
            }
            node = node.getKey(ch);
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    public void getAllWords(TrieNode node,String word){
        if(node==null) return;


    }

    public static void main(String[] args) {
        TrieLeetCode t = new TrieLeetCode();
    /*    t.insert("a");
        t.insert("aa");
        t.insert("aaa");
        System.out.println(t.searchPrefix("a").isEnd);*/
        String[] words={"cat", "ball","bat","rat", "cap","be","balle"};
        for(String word:words) t.insert(word);
        TrieNode node= t.searchPrefix("ba");


//        int ans=0;
//        Arrays.sort(words,new CompareByLength());
//        for(int i=0;i<words.length;i++) {
//            words[i] = new StringBuilder(words[i]).reverse().toString();
//            TrieNode node=t.searchPrefix(words[i]);
//            if(node!=null) continue;
//            else
//                ans+=words[i].length()+1;
//
//            t.insert(words[i]);
//        }
//        System.out.println(ans);




    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */