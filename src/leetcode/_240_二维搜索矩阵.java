package leetcode;

public class _240_二维搜索矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (flag) break;
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[j][i] > target) {
                    flag = true;
                }
            }
        }
        return false;


    }
}
