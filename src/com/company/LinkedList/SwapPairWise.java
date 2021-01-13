package com.company.LinkedList;

public class SwapPairWise {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode swaps(ListNode head){

    if(head==null || head.next==null) return head;
    ListNode x=head.next;
    head.next=swaps(head.next.next);
    x.next=head;
    return x;
        }
        public static void main(String[] args) {
        SwapPairWise s=new SwapPairWise();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        s.swaps(head);
    }
}
