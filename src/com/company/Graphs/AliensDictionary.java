package com.company.Graphs;

import java.util.*;

public class AliensDictionary {
    int V;
    LinkedList<Integer> adj[];

    public AliensDictionary(int v) {
        V = v;
        adj=new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int v,int u){
        adj[v].add(u);
    }
    public void getOrder(String[] words){
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    addEdge(word1.charAt(j)-'a',word2.charAt(j)-'a');
                    break;
                }
            }
        }
        topoLogicalSort();
    }
    public void topoLogicalSort(){
        boolean[] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i]=true;
                topSort(i,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print((char)('a' + stack.pop()) + " ");
        }
    }
    public void topSort(int v,boolean[] visited,Stack<Integer> stack){
        Iterator<Integer> i=adj[v].listIterator();
        while (i.hasNext()){
            int temp=i.next();
            if(!visited[temp]){
                visited[temp]=true;
                topSort(temp,visited,stack);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        AliensDictionary a=new AliensDictionary(4);
        String[] words =  {"baa", "abcd", "abca", "cab", "cad"};
        a.getOrder(words);

    }
}
