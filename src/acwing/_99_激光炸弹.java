package acwing;

import java.util.Scanner;

public class _99_激光炸弹 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[][] board = new int[r + 2][r + 2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x + 1][y + 1] = sc.nextInt();
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] = board[i][j - 1] + board[i - 1][j] - board[i - 1][j - 1] + board[i][j];
            }

        }
        System.out.println();

    }
}
