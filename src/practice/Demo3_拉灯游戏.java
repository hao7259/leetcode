package practice;

import java.util.Scanner;

public class Demo3_拉灯游戏 {
    /**
     * 你玩过“拉灯”游戏吗？
     * 25 盏灯排成一个 5×5 的方形。
     * 每一个灯都有一个开关，游戏者可以改变它的状态。
     * 每一步，游戏者可以改变某一个灯的状态。
     * 游戏者改变一个灯的状态会产生连锁反应：和这个灯上下左右相邻的灯也要相应地改变其状态。
     * 我们用数字 1 表示一盏开着的灯，用数字 0 表示关着的灯。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        boolean[][] board = new boolean[5][5];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    int num = sc.nextInt();
                    if (num == 0) {
                        board[i][k] = false;
                    } else if (num == 1) {
                        board[j][k] = true;
                    }
                }
            }
            arr[i] = dfs(board, 0, 0, 0);
        }
        for (int i : arr) {
            if (i == Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(i + " ");
            }
        }

    }

    private static int dfs(boolean[][] board, int row, int col, int count) {
        //递归界：row=5。row=5说明整个数组已经遍历完毕
        //如果符合要求，返回count，不符合返回int的最大整数
        //返回int最大整数而不是-1的原因：
        //若返回-1，假如dfs与dfs2一个值为-1，另一个值为2，在此方法最后的Math.min方法中取到的总是-1，实际上我们需要的是2。这就需要额外的判断，而返回int最大整数只需要在外层替换即可
        if (row == 5) {
            if (check(board)) {
                return count;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        //在到某一行最后一个元素时切换到下一行
        if (col == 5) {
            return dfs(board, row + 1, 0, count);
        }
        //选择此格子
        oper(board, row, col);
        int dfs = dfs(board, row, col + 1, count + 1);
        //复原；复原与选择的操作实际上相同
        oper(board, row, col);

        //不选择此格子
        int dfs2 = dfs(board, row, col + 1, count);
        return Math.min(dfs, dfs2);
    }

    /**
     * 检查灯是否全部点亮
     * 是->返回true
     * 不是是->返回false
     */
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

    private static void oper(boolean[][] board, int row, int col) {
        board[row][col] = !board[row][col];
        if (row > 0) {
            board[row - 1][col] = !board[row - 1][col];
        }
        if (row < 4) {
            board[row + 1][col] = !board[row + 1][col];
        }
        if (col > 0) {
            board[row][col - 1] = !board[row][col - 1];
        }
        if (col < 4) {
            board[row][col + 1] = !board[row][col + 1];
        }
    }

    /**
     * 翻转某一个灯及其相邻的灯操作
     * 将其分为9块，对各种情况讨论
     * 思考之后觉得这种方法比较繁琐，换成了上面那种方法
     */
    @Deprecated
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


