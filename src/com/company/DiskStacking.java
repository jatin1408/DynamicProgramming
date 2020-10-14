package com.company;

import java.util.Arrays;

public class DiskStacking {
    static class Node implements Comparable<Node>{
        int l,w,h,area;

        public Node(int h, int w, int l) {
            this.l = l;
            this.w = w;
            this.h = h;
        }

        @Override
        public int compareTo(Node o) {
            return o.area-this.area;
        }
    }
    public int getMaxHeight(int[][] arr){
        int n=arr.length;
        Node[] boxes=new Node[n*3];
        for(int i=0;i<n;i++){
            boxes[i*3]=new Node(arr[i][0],Math.max(arr[i][2],arr[i][1]),Math.min(arr[i][2],arr[i][1]));
            boxes[i*3+1]=new Node(arr[i][1],Math.max(arr[i][0],arr[i][2]),Math.min(arr[i][0],arr[i][2]));
            boxes[i*3+2]=new Node(arr[i][2],Math.max(arr[i][0],arr[i][1]),Math.min(arr[i][0],arr[i][1]));
            System.out.println(boxes[i].h);
        }
        for(int i=0;i<boxes.length;i++){
            boxes[i].area=boxes[i].w*boxes[i].l;
        }
        Arrays.sort(boxes);
        int count=n*3;
        int[] maxHeight=new int[count];
        for(int i=0;i<count;i++){
            maxHeight[i]=boxes[i].h;
        }
        for(int i=0;i<count;i++) {
            maxHeight[i] = 0;
            Node box = boxes[i];
            int val = 0;
            for (int j = i; j >= 0; j--) {
                if (boxes[j].w > boxes[i].w && boxes[j].l > boxes[i].l) {
                    val = Math.max(val, maxHeight[j]);
                }
            }
            maxHeight[i] = val+box.h;
        }
        int best=-1;
        for(int i=0;i<count;i++){
            best=Math.max(best,maxHeight[i]);
        }
        return best;
    }

    public static void main(String[] args) {
        DiskStacking d=new DiskStacking();
        System.out.println(d.getMaxHeight(new int[][]{{4,6,7},{1,2,3},{4,5,6},{10,12,32}}));

    }
}
