package com.company.LinkedList;

public class InterSectionPointOfLinkedList {
    static class ListNode{
        int val;
        PalindromeLinkedList.ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode getIntersectionPoint(ListNode n1,ListNode n2){
        ListNode one=n1;
        ListNode two=n2;
        int count1=0;
        int count2=0;
        while (one!=null || two!=null){
            if(one.next!=null){
                count1++;
            }
            if(two.next!=null){
                count2++;
            }
        }
        if(count1>count2){
            int res=count1-count2;
            for(int i=0;i<count1;i++){

            }
        }
        else if(count2<count1) {

        }
        return null;
    }
}
