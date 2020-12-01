package com.company;
import java.util.List;
import java.util.ArrayList;
public class PacificAtlanticWaterFlow {

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> res=new ArrayList<>();
            int m=matrix.length;
            if(m==0){
                return res;
            }
            int n=matrix[0].length;
            if(n==0){
                return res;
            }
            boolean[][] pacific=new boolean[m][n];
            boolean[][] atlantic=new boolean[m][n];
            for(int i=0;i<m;i++){
                pacific[i][0]=true;
                atlantic[i][n-1]=true;
            }
            for(int i=0;i<n;i++){
                pacific[0][i]=true;
                atlantic[m-1][i]=true;
            }
            for(int i=0;i<m;i++){
                boolean[][] v1=new boolean[m][n];
                boolean[][] v2=new boolean[m][n];
                helper(matrix,pacific,v1,i,0,m,n);
                helper(matrix,atlantic,v2,i,n-1,m,n);
            }
            for(int i=0;i<n;i++){
                boolean[][] v1=new boolean[m][n];
                boolean[][] v2=new boolean[m][n];
                helper(matrix,pacific,v1,0,i,m,n);
                helper(matrix,atlantic,v2,m-1,i,m,n);
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(pacific[i][j] && atlantic[i][j]){
                        List<Integer> list=new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(new ArrayList<>(list));
                    }
                }
            }
            return res;
        }
        public void helper(int[][] matrix,boolean[][] check,boolean[][] visited,int i,int j,int m,int n){
            visited[i][j]=true;
            check[i][j]=true;
            int[] x = {0,0,1,-1};
            int[] y = {1,-1,0,0};
            for(int k=0;k<4;k++){
                if(i+y[k]>=0 && i+y[k]<m && j+x[k]>=0 && j+x[k]<n && !visited[i+y[k]][j+x[k]] && matrix[i][j]<=matrix[i+y[k]][j+x[k]]){
                    helper(matrix,check,visited,i+y[k],j+x[k],m,n);
                }
            }
        }
    }

