package com.company;

public class DesignCircularQueue {
    class MyCircularQueue {
        int[] queue;
        int size;
        int k;
        int front;
        int rear;
        public MyCircularQueue(int k) {
            this.k=k;
            queue=new int[k];
            size=0;
            front=0;
            rear=-1;
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;
            rear++;
            queue[rear%k]=value;

            size++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            front++;
            size--;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return queue[front%k];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            return queue[rear%k];
        }

        public boolean isEmpty() {
            if(size==0) return true;
            return false;
        }

        public boolean isFull() {
            if(size==k) return true;
            return false;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
