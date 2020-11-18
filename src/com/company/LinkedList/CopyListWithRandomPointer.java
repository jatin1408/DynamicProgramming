package com.company.LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public class Node {
      int val;
      Node next;
      Node random;
      Node(int val) { this.val = val; }
      }
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hashMap=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            Node n=new Node(temp.val);
            hashMap.put(temp,n);
            temp=temp.next;
        }
        Node q=head;
        while(q!=null){
            hashMap.get(q).next=hashMap.get(q.next);
            hashMap.get(q).random=hashMap.get(q.random);
            q=q.next;
        }
        return hashMap.get(head);
    }
    //O(1) SPACE
    public Node copyList(Node head){
        Node curr=head,temp=null;
        while (curr!=null){
            temp=curr.next;
            curr.next=new Node(curr.val);
            curr.next.next=temp;
            curr=temp;
        }
        curr=head;
        while (curr!=null){
            if(curr.next!=null) curr.next.random=curr.random!=null?curr.random.next:null;
            curr=curr.next!=null?curr.next.next:curr.next;
        }
        Node original=head,copy=head.next;
        Node res=copy;
        while (original!=null && copy!=null){
            original.next=original.next!=null?original.next.next: null;
            copy.next=copy.next!=null?copy.next.next:null;
            original=original.next;
            copy=copy.next;
        }
        return res;
    }
}
