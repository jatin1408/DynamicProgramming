package com.company;
import java.util.*;
public class Trie {
    Node root;

    public Trie() {
        root=new Node();
    }

    private class Node{
        Map<Character,Node> child;
        boolean endOfWord;

        public Node() {
            child=new HashMap<>();
            endOfWord=false;
        }
    }
    public void insert(String word){
        Node current=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            Node check=current.child.get(ch);
            if(check==null){
                check=new Node();
                current.child.put(ch,check);
            }
            current=check;
        }

        current.endOfWord=true;
    }
    public boolean search(String word){

        Node current=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(current.child.get(ch)==null){
                return false;
            }
            current=current.child.get(ch);
        }
        return current.endOfWord;
    }
    public boolean delete(String word,int index,Node current){
        if(index==word.length()){
            if(!current.endOfWord){
                return false;
            }
            current.endOfWord=false;
            return current.child.size()==0;
        }
        char ch=word.charAt(index);
        Node check=current.child.get(ch);
        if(check==null){
            return false;
        }
        boolean del=delete(word,index+1,check);
        if(del){
            current.child.remove(ch);
            return current.child.size()==0;

        }
        return false;
    }


    public static void main(String[] args) {
        Trie t=new Trie();
       t.insert("geeksforgeeks");
       t.insert("geeks");
       t.insert("geek");

    }
}
