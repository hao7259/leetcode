package practice2;

import java.util.Scanner;

public class demo_数的范围 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= q; i++) {
            int x = sc.nextInt();
            int l = 1, r = n;
            //找左边的边界值
            //[l,mid][mid+1,r]
            while (l < r) {
                int mid = l + r >> 1;
                if (arr[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (arr[l] != x) {
                //没找到
                System.out.print("-1 -1");
            } else {
                //找到了
                //往下找右边边界值
                System.out.print(l + " ");
                r = n;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (arr[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }
            //[l,mid-1][mid,r]
            //需要在计算mid时+1
        }
    }
}
