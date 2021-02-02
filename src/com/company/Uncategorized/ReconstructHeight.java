package com.company.Uncategorized;
import java.util.Comparator;
import java.util.Arrays;
public class ReconstructHeight {

        class CompareByHeights implements Comparator<int[]> {
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        }
        public int[][] reconstructQueue(int[][] people) {

            Arrays.sort(people,new CompareByHeights());
            int n=people.length;
            int[][] res=new int[n][2];
            for(int[] arr:res){
                Arrays.fill(arr,-1);
            }
            for(int i=0;i<n;i++){
                int count=people[i][1];
                for(int j=0;j<n;j++){
                    if(count==0 && res[j][0]==-1){
                        res[j][0]=people[i][0];
                        res[j][1]=people[i][1];
                        break;
                    }
                    else if(res[j][0]>=people[i][0] || res[j][0]==-1){
                        count-=1;
                    }
                }
            }
            return res;
        }
    }
