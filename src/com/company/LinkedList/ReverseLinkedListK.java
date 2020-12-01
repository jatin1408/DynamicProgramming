package com.company.LinkedList;

public class ReverseLinkedListK {
    ListNode head=null;
    ListNode last=null;
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val=val;
        }
    }
    public ListNode reverseLL(ListNode head,int k){
        int count=0;
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while (count<k && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null){
            head.next=reverseLL(next,k);
        }
        return prev;
    }
    public void addToList(int val){
        ListNode n=new ListNode(val);
        if(head==null){
            head=n;
            last=n;
            return;
        }
        last.next=n;
        last=n;
    }
    void printList(ListNode head){
        ListNode curr=head;
        while (curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedListK r=new ReverseLinkedListK();
        r.addToList(1);
        r.addToList(2);
        r.addToList(3);
        r.addToList(4);
        r.addToList(5);
        r.addToList(6);
        r.addToList(7);
        r.addToList(8);
        r.printList(r.head);
        ListNode newR=r.reverseLL(r.head,3);
        r.printList(newR);


    }
}
