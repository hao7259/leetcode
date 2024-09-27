package acwing;

import java.util.Scanner;

public class demo_分巧克力 {
    static int[][] arr;
    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            max = Math.max(max, Math.max(arr[i][0], arr[i][1]));
        }
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (test(mid)) r = mid - 1;
            else l = mid;
        }
        System.out.println(r);
        /*
         * [l,r]
         * [l,mid][mid+1,r]
         * */

    }

    private static boolean test(int dest) {
//        3*6   3
//
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i][0] / dest) * (arr[i][1] / dest);
        }
        return sum < k;
    }
}
