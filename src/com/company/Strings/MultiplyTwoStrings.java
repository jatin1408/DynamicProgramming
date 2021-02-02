package com.company.Strings;

public class MultiplyTwoStrings {
        public String multiply(String num1, String num2) {
            int n1=num1.length();
            int n2=num2.length();
            boolean one=true;
            boolean second=true;
            for(int i=0;i<n1;i++)
                if(num1.charAt(i)!='0') one=false;


            for(int i=0;i<n2;i++)
                if(num2.charAt(i)!='0') second=false;

            if(one || second) return "0";
            if(n2>n1) {
                String temp=num1;
                num1=num2;
                num2=temp;
                int temp1=n1;
                n1=n2;
                n2=temp1;
            }

            int st=0;

            StringBuilder prev=null;
            for(int i=n2-1;i>=0;i--){
                int in=n1-1;
                int carry=0;
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<st;j++)
                    sb.insert(0,'0');

                while(in>=0){
                    int num=Character.getNumericValue(num2.charAt(i)) * Character.getNumericValue(num1.charAt(in));
                    num+=carry;
                    carry=num/10;
                    if(in==0)
                        sb.insert(0,num);

                    else
                        sb.insert(0,num%10);


                    in--;
                }
                if(prev!=null){
                    int p=prev.length() - 1;
                    int sbn=sb.length() - 1;
                    int carry1=0;
                    StringBuilder newSb=new StringBuilder();
                    while (p>=0 || sbn>=0){
                        int res=0;
                        if(p>=0) res+=Character.getNumericValue(prev.charAt(p--));
                        if(sbn>=0) res+=Character.getNumericValue(sb.charAt(sbn--));
                        res+=carry1;
                        carry1=res/10;
                        newSb.insert(0,res%10);
                    }
                    if(carry1>0) newSb.insert(0,carry1);

                    prev=newSb;
                }
                else prev=sb;
                st++;
            }

            return prev.toString();
        }
    }

