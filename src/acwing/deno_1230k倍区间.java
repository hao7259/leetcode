package acwing;

import java.util.Scanner;

public class deno_1230k倍区间 {
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
