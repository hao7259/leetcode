package acwing;

import java.util.Scanner;

public class _99_激光炸弹_f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        //初始化max为int最小值，常用手法：求最大值初始化为最小
        int max = Integer.MIN_VALUE;
        int[][] board = new int[5002][5002];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            //一个格子上可能有很多目标，格子上有很多目标时直接将价值相加就可以。
            if (board[x + 1][y + 1] != 0) {
                board[x + 1][y + 1] += sc.nextInt();
            } else {
                board[x + 1][y + 1] = sc.nextInt();
            }
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                //计算当前的二维前缀和
                board[i][j] = board[i][j - 1] + board[i - 1][j] - board[i - 1][j - 1] + board[i][j];
                //比较前面的最大值与将炸弹放在此位置那个得分高
                //此位置指的是右下角为i，j，边长为r的正方形。
                if (i >= r && j >= r) {
                    max = Math.max(max, board[i][j] - board[i - r][j] - board[i][j - r] + board[i - r][j - r]);
                }
            }
        }
        //如果炸弹可以覆盖整个棋盘，得分就整个棋盘的价值加起来
        if (r > 5000)
            System.out.println(board[5001][5001]);
        else
            System.out.println(max);
    }
}
