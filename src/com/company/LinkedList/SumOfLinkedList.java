package com.company.LinkedList;

public class SumOfLinkedList {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;
      }
      }

    public ListNode addTwoNumbers(ListNode p, ListNode q) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        ListNode l1=p;
        ListNode l2=q;
        while(l1!=null || l2!=null){
            int a=l1==null?0:l1.val;
            int b=l2==null?0:l2.val;
            int sum=a+b+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;

        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return dummy.next;
    }
}
