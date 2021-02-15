package com.company.LinkedList;

public class RearrangeLLFromMiddle {

     static class ListNode{
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }
        static ListNode rearrange(ListNode head){
            ListNode mh=findMiddle(head);
            ListNode middle=mh;
            ListNode reversed=reverse(head,middle);
            while (reversed!=null && middle!=null){
                ListNode temp=reversed.next;
                ListNode mid=middle.next;
                middle.next=reversed;
                reversed.next=mid;
                reversed=temp;
                middle=mid;
            }

     /*while (mh!=null){
         System.out.println(mh.val);
         mh=mh.next;
     }*/
            return mh;
        }
        static ListNode reverse(ListNode head,ListNode middle){
            if(head==null) return null;
            ListNode prev=null,next,curr=head;
            while (curr!=null && curr!=middle){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            return prev;
        }
        static ListNode findMiddle(ListNode head){
            ListNode slow=head,fast=head.next;
            while (fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            if(fast!=null) slow=slow.next;
            return slow;
        }
        public static void main(String[] args) {
            ListNode listNode=new ListNode(1);
            listNode.next=new ListNode(2);
            listNode.next.next=new ListNode(3);
            listNode.next.next.next=new ListNode(4);
            listNode.next.next.next.next=new ListNode(5);
            listNode.next.next.next.next.next=new ListNode(6);
            listNode.next.next.next.next.next.next=new ListNode(7);
            rearrange(listNode);
        }
    }

