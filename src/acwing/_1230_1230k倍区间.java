package acwing;

import java.util.Scanner;

public class _1230_1230k倍区间 {
    /*
    *     * 给定一个长度为 N的数列，A1,A2,…AN，如果其中一段连续的子序列 Ai,Ai+1,…Aj之和是K的倍数，我们就称这个区间 [i,j]是 K倍区间。

你能求出数列中总共有多少个 K倍区间吗？

输入格式
第一行包含两个整数 N和 K。

以下 N行每行包含一个整数 Ai。

输出格式
输出一个整数，代表 K倍区间的数目。

数据范围
1≤N,K≤100000
,
1≤Ai≤100000
* */
    /*
    * 思路：枚举每一个数字的最右边。
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n + 1];
        int[] cnt = new int[n + 1];
        long res = 0;
        cnt[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong() + arr[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            res += cnt[(int) (arr[i] % k)];
            cnt[(int) (arr[i] % k)]++;
        }
        System.out.println(res);
    }


    //前缀和优化
    public static void fun2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt() + arr[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if ((arr[j] - arr[i - 1]) % target == 0) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    //暴力搜索
    public static void fun1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum % target == 0) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
