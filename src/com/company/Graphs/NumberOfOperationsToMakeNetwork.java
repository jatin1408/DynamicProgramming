package com.company.Graphs;

public class NumberOfOperationsToMakeNetwork {

        public int findParent(int i,int[] parent){
            if(parent[i]==i) return parent[i];
            return parent[i]=findParent(parent[i],parent);

        }

        public int makeConnected(int n, int[][] c) {
            int[] parent=new int[n];
            int r=0;
            for(int i=0;i<n;i++)
                parent[i]=i;
            for(int i=0;i<c.length;i++){
                int  p1=findParent(c[i][0],parent);
                int  p2=findParent(c[i][1],parent);
                if(p1==p2) r++;
                else
                    parent[p2]=p1;

            }
            int root=0;
            for(int i=0;i<n;i++)
                if(parent[i]==i)
                    root++;
            return (r>=root-1?root-1:-1);
        }
    }

