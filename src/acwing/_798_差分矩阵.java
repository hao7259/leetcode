package acwing;

import java.util.Scanner;

public class _798_差分矩阵 {
    /*
    输入一个 n行 m列的整数矩阵，再输入 q个操作，每个操作包含五个整数 x1,y1,x2,y2,c
    其中 (x1,y1) 和 (x2,y2) 表示一个子矩阵的左上角坐标和右下角坐标。
    每个操作都要将选中的子矩阵中的每个元素的值加上 c
    请你将进行完所有操作后的矩阵输出。
    输入格式
    第一行包含整数 n,m,q。
    接下来 n 行，每行包含 m 个整数，表示整数矩阵。
    接下来 q 行，每行包含 5 个整数 x1,y1,x2,y2,c，表示一个操作。

    输出格式
    共 n 行，每行 m 个整数，表示所有操作进行完毕后的最终矩阵。

    数据范围
    1≤n,m≤1000
    1≤q≤100000
    1≤x1≤x2≤n
    1≤y1≤y2≤m
    −1000≤c≤1000
    −1000≤矩阵内元素的值≤1000

3 4 3
1 2 2 1
3 2 2 1
1 1 1 1
1 1 2 2 1
1 3 2 3 2
3 1 3 4 1

2 3 4 1
4 3 4 1
2 2 2 2

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] oran = new int[n + 2][m + 2];//原数组
        int[][] diff = new int[n + 2][m + 2];//差分数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                oran[i][j] = sc.nextInt();
                insert(diff, i, j, i, j, oran[i][j]);
            }
        }
        System.out.println();
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();
            insert(diff, x1, y1, x2, y2, c);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                oran[i][j] = diff[i][j]
                        + oran[i - 1][j]
                        + oran[i][j - 1]
                        - oran[i - 1][j - 1];
                System.out.print(oran[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void insert(int[][] diff, int x1, int y1, int x2, int y2, int c) {
        diff[x1][y1] += c;
        diff[x2 + 1][y1] -= c;
        diff[x1][y2 + 1] -= c;
        diff[x2 + 1][y2 + 1] += c;
    }
}
