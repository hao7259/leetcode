package leetcode;

public class _37_解数独 {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solveSudoku(board, row + 1, 0);
        if (board[row][col] != '.') return solveSudoku(board, row, col + 1);

        for (char i = '1'; i <= '9'; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                if (solveSudoku(board, row, col + 1))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        // 检查行是否满足
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
        }
        // 检查列是否满足
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }
        //检查在3*3子组是否满足
        int rowStart = 3 * (row / 3), colStart = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowStart + i][colStart + j] == c) return false;
            }
        }
        return true;
    }


}
