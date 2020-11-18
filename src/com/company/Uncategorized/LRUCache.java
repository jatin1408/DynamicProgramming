package com.company.Uncategorized;
import java.util.*;
public class LRUCache {
        int c;
        LinkedList<Integer> l;
        HashMap<Integer,Integer> map;
        public LRUCache(int capacity) {
            c=capacity;
            l=new LinkedList<>();
            map=new HashMap<>();
        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            l.remove(new Integer(key));
            l.add(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                get(key);
                map.replace(key,value);
            }

            else{
                if(l.size()==c){
                    int temp=l.removeFirst();
                    map.remove(temp);
                }
                l.add(key);
                map.put(key,value);
            }
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

