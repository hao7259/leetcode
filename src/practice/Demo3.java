package practice;

import java.util.Scanner;


/**
 * ClassName: Demo1
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 董文强
 * @Create 2024/9/2 0002 15:22
 * @Version v1.0
 */
/*
*
* 题目：从1-n这n个整数中随机选取，输出所有可以的选择方案
* 解析：考虑用递归：其实就是dfs（回溯法），使用递归搜索树来考虑解决这个问题。
* 对于一个数有两种可能：选择或者不选择,递归树，定义一个函数，这个函数就是对每一数选或者是不选，选完这个数，下一个数我们采用递归的形式进行
主要思路：这里定义一个数组：用来记录每个数字到底选还是没选，tag数组。比如：tag[0]=1代表1这个数字选了，tag[0]=2代表1这个数字没选。
如果想要将所有的方案保存下来。那么需要定义一个二维数组。
* 数组的行表示第几种方案，列表示每一种方案中的n个数
* int a[][]=new int[2的n次方][n]
* * */
public class Demo3 {
    //static int[][] ways =new int [(int) Math.pow(2,16)][16];//这里写16是因为题目给的数据范围是1<=n<=15.
    static int count = 0;//表示有几种方案。

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//输入N的取值。
        int[] tag = new int[N + 1];//定义数组来表示每个位置当前的状态。选了还是没选还是待考虑。1表示选了，2代表没选，0代表待考虑状态。
        dfs(1, N, tag);//调用，首先看看1这个元素有没有被选中，第一个参数是0，是因为一会有数组操作，数组0号下标就是代表数字1.
        //第二个参数N代表有多少个数字，tag代表我们的辅助数组。第一个参数是当前枚举（考虑）到第几个，第二个参数是当前选了多少个，第三个是记录状态的数组。
    }

    public static void dfs(int n, int N, int[] r) {
        if (n > N) {//其实这个n也代表你递归了几层,如果说n>N说明已经全部选择完了。直接打印结果就行了。
            count++;
            for (int i = 1; i <= N; i++) {
                if (r[i] == 1) {//遍历这个数组，如果对应位置是1，说明选择了这个数字，否则就没选
//                        ways[count][i]=i;
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            //否则，就对当前节点第 n个数字进行处理，两种处理：选择或者不选择，
            r[n] = 2;//不选择。对应位置写成2
            dfs(n + 1, N, r);//继续判断下一个元素。递归
            r[n] = 0;//恢复现场
            r[n] = 1;//选择数组对应位置写成1，
            dfs(n + 1, N, r);//继续判断下一个元素。递归
            r[n] = 0;//恢复现场
        }
    }
}

