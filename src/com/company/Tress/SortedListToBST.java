package com.company.Tress;
import java.util.*;
public class SortedListToBST {

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        private List<Integer> v=new ArrayList<>();
        void listToArray(ListNode head){
            while(head!=null){
                v.add(head.val);
                head=head.next;
            }
        }
        public TreeNode sortedListToBST(ListNode head) {
            if(head==null){
                return null;
            }
            listToArray(head);
            return construct(0,v.size()-1);
        }
        public TreeNode construct(int left,int right){
            if(left>right){
                return null;
            }
            int mid=(left+right)/2;
            TreeNode node=new TreeNode(v.get(mid));
            if(left==right){
                return node;
            }
            node.left=construct(left,mid-1);
            node.right=construct(mid+1,right);
            return node;
        }
    }
}
