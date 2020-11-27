package com.company.Uncategorized;

public class SpecialStack {
    int MAX=300;
    int[] arr=new int[MAX];
    int size=0;
    int index=0;
    int MAX_VALUE;
    public boolean push(int val){
        if(size>=MAX)
            return false;
        if(size==0) {
            MAX_VALUE = val;
            arr[index++] = val;
            size++;
            return true;
        }
        if(val>MAX_VALUE) {

            int store=2*val-MAX_VALUE;
            MAX_VALUE=val;
            arr[index++]=store;
        }
        else
            arr[index++] = val;
        size++;
        return true;
    }
    public int pop(){
        if(size<0)
            return -1;

        int t=arr[--index];
        if(t>MAX_VALUE){
            int res=MAX_VALUE;
            MAX_VALUE=2*MAX_VALUE-t;
            size--;
            return res;
        }
        size--;
        return t;

    }
    public int getMax(){
        return MAX_VALUE;
    }

    public static void main(String[] args) {
        SpecialStack s=new SpecialStack();
        System.out.println(s.push(3));
        System.out.println(s.push(5));

        System.out.println(s.getMax());

        System.out.println(s.push(7));
        System.out.println(s.push(19));
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());


    }

}
