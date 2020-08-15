package com.company;

class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0) && helper(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] b,String w,int i,int j,int count){
        if(w.length()==count){
            return true;
        }
        if(i<0 || i>=b.length || j<0 || j>=b[i].length || b[i][j]!=w.charAt(count)){
            return false;
        }
        char temp=b[i][j];
        b[i][j]=' ';
        boolean found= helper(b,w,i+1,j,count+1) || helper(b,w,i-1,j,count+1) || helper(b,w,i,j-1,count+1) || helper(b,w,i,j+1,count+1);
        b[i][j]=temp;
        return found;
    }
}