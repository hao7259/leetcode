package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _37_解数独 {
    public void solveSudoku(char[][] board) {

    }

    private boolean checkRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>(9);
        for (char curchar : board[row]) {
            if (curchar == '.') continue;
            set.add(curchar);
        }
        if (set.size() == 9) return true;

        return false;
    }

}
