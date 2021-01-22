package com.company.Uncategorized;
import java.util.*;
public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] arr) {
            int rows2=arr.length-1;
            int rows1=0;
            int cols2=arr[0].length-1;
            int cols1=0;
            List<Integer> res=new ArrayList<>();
            while (rows1<=rows2 && cols1<=cols2){

                for(int i=cols1;i<=cols2;i++){

                    res.add(arr[rows1][i]);
                }
                int temp=rows1+1;

                while (temp<=rows2){

                    res.add(arr[temp][cols2]);
                    temp++;
                }
                if(rows1<rows2 && cols1<cols2) {


                    for (int i = cols2-1; i >cols1; i--) {

                        res.add(arr[rows2 ][i] );
                    }
                    temp = rows2;
                    while (temp > rows1) {
                        res.add(arr[temp][cols1] );
                        temp--;
                    }
                }
                rows1++;
                rows2--;
                cols1++;
                cols2--;

            }
            return res;
        }
    }
}
