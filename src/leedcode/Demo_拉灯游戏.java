package leedcode;

import java.util.Scanner;

/**
 * 你玩过“拉灯”游戏吗？
 * 25 盏灯排成一个 5×5 的方形。
 * 每一个灯都有一个开关，游戏者可以改变它的状态。
 * 每一步，游戏者可以改变某一个灯的状态。
 * 游戏者改变一个灯的状态会产生连锁反应：和这个灯上下左右相邻的灯也要相应地改变其状态。
 * 我们用数字 1 表示一盏开着的灯，用数字 0 表示关着的灯。
 * 输入格式
 * 第一行输入正整数 n，代表数据中共有 n个待解决的游戏初始状态。
 * <p>
 * 以下若干行数据分为 n组，每组数据有 5行，每行 5个字符。每组数据描述了一个游戏的初始状态。各组数据间用一个空行分隔。
 * <p>
 * 输出格式
 * 一共输出 n行数据，每行有一个小于等于 6 的整数，它表示对于输入数据中对应的游戏状态最少需要几步才能使所有灯变亮。
 * <p>
 * 对于某一个游戏初始状态，若 6步以内无法使所有灯变亮，则输出 −1。
 * 输入样例：
 * 3
 * <p>
 * 00111
 * 01011
 * 10001
 * 11010
 * 11100
 * <p>
 * 11101
 * 11101
 * 11110
 * 11111
 * 11111
 * <p>
 * 01111
 * 11111
 * 11111
 * 11111
 * 11111
 * 输出样例：
 * 3
 * 2
 * -1
 */
public class Demo_拉灯游戏 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        String temp;
        int[][] board = new int[5][5];
        int[][] tempBoard = new int[5][5];  //备用数组因为第一行有32中可能，每种可能都会改变map数组，我们为了确保答案的准确性需要还原map
        int res = 9999;
        while ((N--) != 0) {  //
            //问题一：这里让N--(代表有几种要解决的状态)是为啥，每次进循环就会完成一个新的5 * 5 的方阵
            for (int i = 0; i < 5; i++) { //输入五个字符串代表五行
                temp = input.next();
                res = 9999;
                for (int j = 0; j < 5; j++) //列
                    board[i][j] = temp.charAt(j) - '0';//把char型变为int,存入数组
            }
            dfs(board, tempBoard, res);

        }
    }
//11111
//00000
    public static void dfs(int[][] map, int[][] tempmap, int res) {
        for (int i = 0; i < 32; i++) { //这里是位运算 2的五次方 直接写32也行
            //每一行都有32种可能去排布
            int step = 0;//步数
            //先把map复制一遍等会还原
            //
            for (int col = 0; col < 5; col++) {
                System.arraycopy(map[col], 0, tempmap[col], 0, 5);
            }
            //一行里面的列数，一共是5列
            for (int j = 0; j < 5; j++) {
                if ((i >> j & 1) == 1) {   //位运算32种情况每种用5的二进制表示
                    // 用1表示要按第一行这个灯 0表示不按这个灯
                    step++;
                    turn(0, j, map);// 这里只是确定第一行所以是0，j;
                }
            }
            for (int k = 0; k < 4; k++) {     //只要确定前四行即可
                for (int m = 0; m < 5; m++) {
                    if (map[k][m] == 0) {
                        step++;
                        //上一行只能由下一行来确定
                        turn(k + 1, m, map);
                    }
                }
            }
            int flag = 0;
            //循环结束后判断最后一行是否为亮
            for (int m = 0; m < 5; m++) {
                if (map[4][m] == 0) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 0) {
                res = Math.min(step, res);
            }
            //这里还要把map还原，因为他有32种可能性
            for (int k = 0; k < 5; k++) {
                System.arraycopy(tempmap[k], 0, map[k], 0, 5);
            }
        }
        if (res > 6) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }
    public static void turn(int x, int y, int[][] map) {
        for (int i = 0; i < 5; i++) {
            int tempx = x + map[x][i];
            int tempy = y + map[i][y];
            if (tempx >= 0 && tempx < 5 && tempy >= 0 && tempy < 5) {
                map[tempx][tempy] ^= 1;  // 异或运算 写成if(map[x][y]==1) map[x][y]==0这种也行

            }
//            0^1=1
//            1^1=0
        }

    }
}



