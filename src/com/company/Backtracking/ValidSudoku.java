package com.company.Backtracking;

public class ValidSudoku {
    public boolean solveHelper(int[][] board){
        int n=3;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    for(int c=1;c<9;c++){
                        if(isValid(board,i,j,c,n)){
                            board[i][j]=c;
                            if(solveHelper(board))
                                return true;
                            else {
                                board[i][j]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(int[][] board,int i,int j,int c,int n){
            for(int row=0;row<9;row++){
            if(board[i][row]==c){
                return false;
            }
        }
        for(int col=0;col<9;col++){
            if(board[col][j]==c){
                return false;
            }
        }

        int start=i<=n?0:(i/n)*n;
        int end=j<=n?0:(j/n)*n;
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = i - i % sqrt;
        int boxColStart = j - j % sqrt;
        System.out.println("row=  "+start +" "+boxRowStart);
        System.out.println("col=  "+end +" "+boxColStart);
        for(int row=start;row<start+n;row++){
            for(int col=end;col<end+n;col++){
                if(board[row][col]==c){
                    return false;
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
        int[][] c={ {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        ValidSudoku v=new ValidSudoku();
        v.solveHelper(c);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
