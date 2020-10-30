package com.company.Uncategorized;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeStrings {
    class Node{
        int val;
        char ch;
        public Node(int val,char ch){
            this.ch=ch;
            this.val=val;
        }

    }
    class KeyComparator implements Comparator<Node> {


        public int compare(Node k1, Node k2)
        {
            if (k1.val < k2.val)
                return 1;
            else if (k1.val > k2.val)
                return -1;
            return 0;
        }
    }
    public String reorganizeString(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']+=1;
        }
        PriorityQueue<Node> p=new PriorityQueue<>(new KeyComparator());
        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (arr[val] > 0)
                p.add(new Node(arr[val], c));
        }
        StringBuilder sb=new StringBuilder();
        while(p.size()>1){
            Node n1=p.remove();
            Node n2=p.remove();
            sb.append(n1.ch);
            sb.append(n2.ch);
            n1.val-=1;
            n2.val-=1;
            if(n1.val>0){
                p.add(n1);
            }
            if(n2.val>0){
                p.add(n2);
            }
        }
        if(!p.isEmpty()){
            Node n=p.remove();
            if(n.val>1){
                return "";
            }
            sb.append(n.ch);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        ReorganizeStrings r=new ReorganizeStrings();
        System.out.println(r.reorganizeString("aabcd"));

    }
}
