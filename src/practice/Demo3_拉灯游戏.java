package practice;

import java.util.Scanner;

public class Demo3_拉灯游戏 {
    /*
    * 你玩过“拉灯”游戏吗？
25 盏灯排成一个 5×5 的方形。
每一个灯都有一个开关，游戏者可以改变它的状态。
每一步，游戏者可以改变某一个灯的状态。
游戏者改变一个灯的状态会产生连锁反应：和这个灯上下左右相邻的灯也要相应地改变其状态。
我们用数字 1 表示一盏开着的灯，用数字 0 表示关着的灯。
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        boolean[][] board = new boolean[5][5];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (sc.nextInt() == 0) {
                        board[i][k] = false;
                    } else if (sc.nextInt() == 1) {
                        board[j][k] = true;
                    } else {
                        System.out.println("参数错误");
                        return;
                    }
                }
            }
            arr[i] = dfs(board, 0, 0, 0);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static int dfs(boolean[][] board, int row, int col, int count) {
        




    }
    private static boolean check(boolean[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void operate(boolean[][] board, int row, int col) {
        if (row == 0 && col == 0) {
            //左上角
            board[row][col] = !board[row][col];
            board[row][col + 1] = !board[row][col + 1];
            board[row + 1][col] = !board[row + 1][col];
        } else if (row == 0 && col == 4) {
            //右上角
            board[row][col] = !board[row][col];
            board[row][col - 1] = !board[row][col - 1];
            board[row + 1][col] = !board[row + 1][col];
        } else if (row == 4 && col == 0) {
            //左下角
            board[row][col] = !board[row][col];
            board[row][col + 1] = !board[row][col + 1];
            board[row - 1][col] = !board[row - 1][col];
        } else if (row == 4 && col == 4) {
            //右下角
            board[row][col] = !board[row][col];
            board[row][col - 1] = !board[row][col - 1];
            board[row - 1][col] = !board[row - 1][col];
        } else if (row == 0) {
            //第0行中间三个
            board[row][col] = !board[row][col];
            board[row][col + 1] = !board[row][col + 1];
            board[row][col - 1] = !board[row][col - 1];
            board[row + 1][col] = !board[row + 1][col];
        } else if (row == 4) {
            //第4行中间三个
            board[row][col] = !board[row][col];
            board[row][col + 1] = !board[row][col + 1];
            board[row][col - 1] = !board[row][col - 1];
            board[row - 1][col] = !board[row - 1][col];
        } else if (col == 0) {
            //第0列中间三个
            board[row][col] = !board[row][col];
            board[row + 1][col] = !board[row + 1][col];
            board[row - 1][col] = !board[row - 1][col];
            board[row][col + 1] = !board[row][col + 1];
        } else if (col == 4) {
            //第4列中间三个
            board[row][col] = !board[row][col];
            board[row + 1][col] = !board[row + 1][col];
            board[row - 1][col] = !board[row - 1][col];
            board[row][col - 1] = !board[row][col - 1];
        } else {
            //中间9个
            board[row][col] = !board[row][col];
            board[row + 1][col] = !board[row + 1][col];
            board[row - 1][col] = !board[row - 1][col];
            board[row][col + 1] = !board[row][col + 1];
            board[row][col + 1] = !board[row][col + 1];
        }

    }
}
