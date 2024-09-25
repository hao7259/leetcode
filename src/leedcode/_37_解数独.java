package leedcode;

/**
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
class _37_解数独 {
    public void solveSudoku(char[][] board) {
        place(0,0,board);
    }

    //放
    public boolean place(int row, int col,char[][] board) {
//        if (row == 9 && col == 9 )   return  true;
        if (row == 9)   return  true;
        //qu1:你的col和row的下标应该是0-8（一共9行）条件应该是row==9就可以（此时应该是row==9，col==0）
        if (col == 9 && row < 9)    return place(row + 1, 0,board);
        //qu2:这里写成col==9就行，不需要关心row，你这样其实也行，就是会多判断一行
        if (board[row][col] != '.') return place(row, col + 1,board);
        //qu3：这一格不等于.说明这一格有数字了，直接判断下一个格子就行，但是你这里还是会执行后面的循环，这里应该直接return掉
        //数字匹配
        for (char l = '1'; l <= '9'; l++) {
            if (isValid(row, col, l,board)) {
                board[row][col] = l; //true直接赋值
//                if (isValid(row, col + 1, l,board)) { //检测之后的不行的话直接回溯
                if (place(row, col + 1,board)) { //检测之后的不行的话直接回溯
                    return true;
                }
                board[row][col] = '.'; //回溯
            }
        }
        return false;
    }

    public boolean isValid(int row, int col, char l,char[][] board) {
        //开始检测能不能放
        //看看之前的
        //先看本行
        for (int k = 0; k < 9; k++) { //行不变列变
            if (board[row][k] == l) return false;
        }
        //看本列
        for (int k = 0; k < 9; k++) {
            if (board[k][col] == l) return false;
        }
        //看小方格
        int rowStart = 3 * (row / 3), colStart = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowStart + i][colStart + j] == l) return false;
            }
        }
        return true;
    }

}