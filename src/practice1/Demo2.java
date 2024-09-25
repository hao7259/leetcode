package practice1;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dfs(1, n, new byte[n + 1], 0, m);
    }

    static void dfs(int cur, int total, byte[] arr, int count, int m) {
        if (count > m) return;
        //剪枝，如果选够了就直接返回
        if (cur > total) {
            if (count == m) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 1) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
            }

        } else {
            //选择这个数字
            arr[cur] = 1;
            dfs(cur + 1, total, arr, count + 1, m);
//            arr[cur]=0;
            //不选择这个数字
            arr[cur] = 2;
            dfs(cur + 1, total, arr, count, m);
            arr[cur] = 0;
        }


    }


}
