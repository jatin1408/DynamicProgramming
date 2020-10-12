package com.company.Backtracking;

public class NQueens {
    int[][] board = new int[11][11];

    void nQueens(int n) {
        nQueenHelper(0, n);
    }

    void nQueenHelper(int row, int n) {
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }


            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            if (isPossible(row, i, n)) {
                board[row][i] = 1;
                nQueenHelper(row + 1, n);
                board[row][i] = 0;
            }

        }
    }

    boolean isPossible(int row, int col, int n) {
        for (int i = row - 1; i >= 0; i--)
            if (board[i][col] == 1)
                return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;

            return true;
        }

    public static void main(String[] args) {
        NQueens nQueens=new NQueens();
        nQueens.nQueens(4);
    }
    }


