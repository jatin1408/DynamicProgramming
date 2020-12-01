package com.company.Uncategorized;

public class GameOfLife {

        public void gameOfLife(int[][] board) {
            int[] inputs=new int[]{1,-1,0};
            int m=board.length;
            int n=board[0].length;
            for(int rows=0;rows<m;rows++){
                for(int cols=0;cols<n;cols++){
                    int live_cells=0;
                    for(int i=0;i<3;i++){
                        for(int j=0;j<3;j++){
                            if(!(inputs[i]==0 && inputs[j]==0)){
                                int r=rows+inputs[i];
                                int c=cols+inputs[j];
                                if((r < m && r >= 0) && (c < n && c >= 0) && (Math.abs(board[r][c]) == 1)){
                                    live_cells+=1;
                                }
                            }
                        }
                    }
                    if((board[rows][cols]==1) && (live_cells<2 || live_cells>3)){
                        board[rows][cols]=-1;
                    }
                    if(board[rows][cols]==0 && live_cells==3){
                        board[rows][cols]=2;
                    }
                }
            }
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] > 0) {
                        board[row][col] = 1;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
        }
    }

