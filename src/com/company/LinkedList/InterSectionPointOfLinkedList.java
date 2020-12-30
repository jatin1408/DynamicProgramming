package com.company.LinkedList;
import java.util.*;
public class InterSectionPointOfLinkedList {
    static class ListNode{
        int data;
        ListNode next;
        public ListNode(int val) {
            this.data = val;
        }
    }


        int intersectionPoint(ListNode head1, ListNode head2)
        {
            HashSet<ListNode> hash=new HashSet<>();
            while(head1!=null){
                hash.add(head1);
                head1=head1.next;
            }
            while(head2!=null){
                if(hash.contains(head2)){
                    return head2.data;
                }
                head2=head2.next;
            }
            return -1;
        }
        //O(1) auxiliary space
        ListNode findPoint(ListNode h1,ListNode h2){
            ListNode p1=h1;
            ListNode p2=h2;
            while (p1!=p2){
                p1=p1.next;
                p2=p2.next;
                if(p1==p2)
                    return p1;
                if(p1==null){
                    p1=h2;
                }
                if(p2==null){
                    p2=h1;
                }
            }
            return p1;
        }

}
