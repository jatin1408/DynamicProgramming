package com.company;
import java.util.*;
//Clean Java Code Written By Jatin Thakwani
public class LongestStringChain {
    static class Node{
        int chain;
        String chainStr;
        public Node(int chain, String chainStr) {
            this.chain = chain;
            this.chainStr = chainStr;
        }
    }
    int longestChain(String[] arr){
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Map<String,Node> hashMap=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            hashMap.put(arr[i],new Node(0,""));
        }
        HashSet<String> hashSet=new HashSet<>(Arrays.asList(arr));
        for(int i=0;i<n;i++){
            String c="";
            int chain=0;
            for(int j=0;j<arr[i].length();j++){
                String s=arr[i].substring(0,j)+arr[i].substring(j+1);

                if(hashSet.contains(s)){
                    int u=hashMap.get(s).chain;
                    if(u>chain){
                        c=s;
                        chain=u;
                    }
                }
            }
            hashMap.replace(arr[i],new Node(chain+1,c));
        }
        String best="";
        int temp=-1;
       for(String key:hashMap.keySet())
           if(temp<hashMap.get(key).chain){
               best=key;
               temp=hashMap.get(key).chain;
           }
       String[] res=new String[temp];
       for(int i=0;i<temp;i++){
           res[i]=best;
           best=hashMap.get(best).chainStr;
       }
       return temp;
    }

    public static void main(String[] args) {
        String[] arr={"abde","abc","abd","abcde","ade","ae","abcdef"};
        LongestStringChain l=new LongestStringChain();
        System.out.println(l.longestChain(arr));
    }
}
