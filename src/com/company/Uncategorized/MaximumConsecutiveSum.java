package com.company.Uncategorized;

public class MaximumConsecutiveSum {
//https://www.geeksforgeeks.org/count-ways-express-number-sum-consecutive-numbers/
        public static int consecutiveNumbersSum(int N) {
            if(N==1) return 1;
            int count=0;
            int s=2;
            while(2*N+s-s*s>0){
                double no=(2*N+s-s*s)/(2*s);
                if(no-(int) no==0){
                    System.out.print(s+" ");
                    System.out.println(no);
                    count++;
                }
                s++;

            }
            System.out.println(count);
            return count;
        }

        public static void main(String[] args) {
            consecutiveNumbersSum(9);
        }
    }

