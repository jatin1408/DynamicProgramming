package com.company.LinkedList;

public class RemoveDuplicatesII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode d=new ListNode(0);
        ListNode dummy=d;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head=head.next;
                }
            }
            else{
                dummy.next=head;
                dummy=head;
            }
            head=head.next;
        }
        dummy.next=null;
        return d.next;
    }
}
