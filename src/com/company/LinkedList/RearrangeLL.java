package com.company.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;

public class RearrangeLL {
     static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
   //o(n) and o(n) space
        public void reorderList(ListNode head) {
            Deque<Integer> dq=new  ArrayDeque<>();
            ListNode dummy=head;
            while(dummy!=null){
                dq.addLast(dummy.val);
                dummy=dummy.next;
            }
            dummy=head;
            int i=0;
            while(!dq.isEmpty()){
                if(i%2==0){
                    dummy.val=dq.removeFirst();
                }
                else{
                    dummy.val=dq.removeLast();
                }
                i++;
                dummy=dummy.next;
            }

        }
        //IN PLACE SOLUTION
    public void reorderListInPlace(ListNode head) {
        if(head==null) return;
        ListNode middle=findMiddle(head);
        ListNode n1=head;
        ListNode n2=middle.next;
        middle.next=null;
        n2=reverse(n2);
        head=new ListNode(0);
        System.out.println(head.next.val);
        ListNode curr=head;
        while(n1!=null || n2!=null){
            if(n1!=null){
                curr.next=n1;
                curr=curr.next;
                n1=n1.next;
            }
            if(n2!=null){
                curr.next=n2;
                curr=curr.next;
                n2=n2.next;
            }
        }
        head=head.next;

    }
    ListNode findMiddle(ListNode head){
        ListNode fast=head;
        ListNode second=head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            second=second.next;
        }

        return second;
    }
    ListNode reverse(ListNode head){
        if(head==null) return head;
        ListNode prev=null,next=null,curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }

    public static void main(String[] args) {

    }
}
