package acwing;

import java.util.Scanner;

public class _797_差分 {
    //差分：输入一个长度为 n的整数序列。
    //
    //接下来输入 m个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r]之间的每个数加上 c。
    //请你输出进行完所有操作后的序列。
    //输入格式
    //第一行包含两个整数 n 和 m。
    //第二行包含 n个整数，表示整数序列。
    //接下来 m行，每行包含三个整数 l，r，c，表示一个操作。
    //输出格式
    //共一行，包含 n个整数，表示最终序列。
    public static void main(String[] args) {
        //思路：构建差分数组将原本O(n)级别的操作降为O(1)；

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n + 2];//原数组
        int[] arr2 = new int[n + 2];//差分数组
        for (int i = 1; i <= n; i++) {
            arr1[i] = sc.nextInt();
            //构建差分数组：
            //方法一，使用定义，
//            arr2[i] = arr1[i] - arr1[i - 1];
            //方法二：视为在[i,i]上，为每个数字加输入的数字，可以套用操作的逻辑
            arr2[i] += arr1[i];
            arr2[i + 1] -= arr1[i];
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr2[l] += c;
            arr2[r + 1] -= c;
        }
        for (int i = 1; i <= n; i++) {
            arr2[i] += arr2[i - 1];
            System.out.print(arr2[i] + " ");
        }
    }

}
