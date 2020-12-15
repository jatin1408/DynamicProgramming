package com.company.Uncategorized;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumKDistinctElements {
        class Node{
            int data;
            int count;
            Node(int data,int count){
                this.data=data;
                this.count=count;
            }
        }
    int mindistinct(int[] Arr,int N,int K){
            //code here
            int[] arr=new int[100001];
            for(int i=0;i<N;i++){
                int val=Arr[i];
                arr[val]+=1;
            }

            PriorityQueue<Node> p=new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.count- o2.count;
                }
            });
            for(int i=0;i<10;i++) {
                if (arr[i] > 0) {


                    p.add(new Node(i, arr[i]));
                }
            }
            while (K>0 && !p.isEmpty()){
                Node temp=p.poll();

                if(temp.count-1>0){
                    p.add(new Node(temp.data,temp.count-1));
                }
                K--;
            }

            return p.size();
        }

        public static void main(String[] args) {
            int[] arr={1,2,3,3,3,4,4};
            int n=7;
            int k=4;
            MinimumKDistinctElements m=new MinimumKDistinctElements();
            m.mindistinct(arr,n,k);
        }

    }

