package practice2;

import java.util.Scanner;

public class demo_机器人跳跃问题 {
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int l = 1;
        int r = 100000;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid)) r = mid;
            else l = mid + 1;
            /*
             * [l,r]
             * [l,mid][mid+1,r]
             * */
        }
        System.out.println(r);
    }

    private static boolean check(int mid) {
        System.out.println("check__" + mid);
        for (int i = 1; i <= n; i++) {
            mid = mid * 2 - arr[i];
            System.out.println(mid);
            if (mid > 100000) {
                return true;
            }
            if (mid < 0) {
                return false;
            }
        }
        return true;
    }
}
