package com.company.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> p=new PriorityQueue<>(
                new Comparator<ListNode>(){
                    public int compare(ListNode a,ListNode b){
                        return a.val-b.val;
                    }
                });
        ListNode head=null,last=null;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                p.add(lists[i]);
            }
        }
        while(!p.isEmpty()){
            ListNode top=p.peek();
            p.remove();
            if(top.next!=null){
                p.add(top.next);
            }
            if(head==null){
                head=top;
                last=top;
            }
            else{
                last.next=top;
                last=top;
            }
        }
        return head;
    }
}
