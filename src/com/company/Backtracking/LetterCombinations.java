package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
        List<String> l=new ArrayList<>();
        public List<String> letterCombinations(String d) {
            int u=d.length();
            if(u==0){
                return l;
            }
            HashMap<Character, List<Character>> hashMap=new HashMap<>();
            int a=97;
            ArrayList<Character> arrayList=new ArrayList<>();
            for(char i='2';i<='9';i++){
                int count=0;
                if(i=='7' || i=='9')
                    while (count<4){
                        arrayList.add((char) a);
                        a++;
                        count++;
                }
                else
                    while (count < 3) {
                        arrayList.add((char) a);
                        a++;
                        count++;
                    }
                hashMap.put(i,new ArrayList<>(arrayList));
                arrayList.clear();
            }
            fun("",u,hashMap,0,d);
            return l;
        }
        void fun(String res,int rem,HashMap<Character,List<Character>> hashMap,int n,String org){
            if(rem<=0){
                l.add(res);
                return;
            }
            char key=org.charAt(n);
            if(key=='7' || key=='9'){
                for (int i = 0; i < 4; i++) {
                    char c = hashMap.get(key).get(i);
                    fun(res + c, rem - 1, hashMap, n + 1, org);
                }
            }
            else {
                for (int i = 0; i < 3; i++) {
                    char c = hashMap.get(key).get(i);
                    fun(res + c, rem - 1, hashMap, n + 1, org);
                }
            }
        }

    public static void main(String[] args) {
        LetterCombinations l=new LetterCombinations();
        for(String obj:l.letterCombinations("342")){
            System.out.println(obj);
        }
    }
    }

