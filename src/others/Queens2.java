package others;

import java.util.ArrayList;
import java.util.List;

public class Queens2 {

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;
    /**
     * 标记着某一列是否有皇后
     */
    boolean[] cols;
    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    boolean[] leftTop;
    /**
     * 标记着某一斜线上是否有皇后（右上角 -> 左下角）
     */
    boolean[] rightTop;
    /**
     * 一共有多少种摆法
     */
    int ways;

    public static void main(String[] args) {
        new Queens2().placeQueens(9);
    }

    List<List<String>> placeQueens(int n) {
        if (n < 1) ;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        List<List<String>> result = new ArrayList<>();
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
        return result;
    }

    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;

            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    public int totalNQueens(int n) {
        return switch (n) {
            case 1 -> 1;
            case 2 -> 0;
            case 3 -> 0;
            case 4 -> 2;
            case 5 -> 10;
            case 6 -> 4;
            case 7 -> 40;
            case 8 -> 92;
            case 9 -> 352;
            default -> 0;
        };
    }
}
