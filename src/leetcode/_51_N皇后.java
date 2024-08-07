package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _51_N皇后 {
    List<List<String>> res;
    int num;
    int[] queens;
    boolean[] cols;
    boolean[] leftTop;
    boolean[] rightTop;



    public List<List<String>> solveNQueens(int n) {
        num = n;
        if (n < 1) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[(leftTop.length)];
        place(0);
        return res;
    }

    private void place(int row) {
        if (row == cols.length) {
            addToRes();
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

    private void addToRes() {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());

        }
        res.add(list);
    }
}
