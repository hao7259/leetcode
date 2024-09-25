package practice2;

import java.util.Scanner;

/**
 * 四平方和定理，又称为拉格朗日定理，
 * 每个正整数都可以表示为至多 4 个正整数的平方和。
 * 如果把 0 包括进去，就正好可以表示为 4 个数的平方和。
 * 比闬Ⅻ醛如:
 * 5 = 1 * 1 + 2 * 2 + 0 + 0
 * 7 = 1 * 1 + 1 * 1 + 2 * 2 + 1 * 1
 * 对于一个给定的正整数，可能存在多种平方和的表示法。
 * 要求你对 4 个数排序:
 * 0<a<b<c<d
 * 并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法.
 * 输入格式
 * 输入一个正整数 N。
 * 输出格式
 * 输出4个非负整数，按从小到大排序，中间用空格分开。
 * 数据范围
 * 0<N<5*10'
 * 输入样例:
 * 5
 * 输出样例:
 * 0 0 1 2
 */
public class Demo {
    static boolean flag;

    public static void main(String[] args) {
        flag = false;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //
        int b = (int) Math.sqrt(n); //5 -> 2  7 -> 2  11 -> 3
        int[] arr = new int[5];
        int sum = 0;
        int count = 0;
        demo(n, b, sum, arr, count);
    }

    public static void demo(int num, int begin, int s, int[] nums, int count) {
        /**
         * 解题思路：
         *      先找到num开放最大的一个整数
         *      然后递归
         */
        if (flag || count == 5) {
            return;
        }

        if (s > num) {
            nums[count] = 0;
            return;
        } //结束递归
        else if (s == num) {
            for (int i = 3; i >= 0; i--) {
                System.out.print(nums[i] + " ");
                flag = true;
            }
        } else {
            s += (int) Math.pow(begin, 2);
            nums[count] = begin;
            demo(num, begin, s, nums, count + 1); //继续选择本数字
            demo(num, begin - 1, s, nums, count + 1);
        }


    }
}
