package com.company.LinkedList;

public class PalindromeLinkedList {
   static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
        return head;
    }
    ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head != null) {
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast!=null){
                slow=slow.next;
            }
            return slow;
        }
        return head;
    }
    boolean palindrome(ListNode head){
        if(head==null)
            return true;
        ListNode middle=getMiddle(head);
        middle=reverse(middle);
        while (middle!=null){
            if(middle.val!=head.val){
                return false;
            }
            middle=middle.next;
            head=head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next=new ListNode(1);
        PalindromeLinkedList p=new PalindromeLinkedList();
        System.out.println(p.palindrome(head));


    }

}
