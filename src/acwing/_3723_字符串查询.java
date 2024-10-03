package acwing;

import java.util.Scanner;

public class _3723_字符串查询 {
    public static void main(String[] args) {
        /*
        1 2 3 4 5
        0 2 3 4 5


         * a[]
         * b[]
         * c[]
         * d[]
         *   */

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int q = sc.nextInt();
        int[][] arr = new int[26][s.length() + 1];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (i == s.charAt(j - 1) - 'a') {
                    arr[i][j] = arr[i][j - 1] + 1;
                } else {
                    arr[i][j] = arr[i][j - 1];
                }
            }
        }
        for (int i = 0; i < q; i++) {
            boolean flag = true;
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y1 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int j = 0; j < 26; j++) {
                if (arr[j][x2] - arr[j][x1 - 1] != arr[j][y2] - arr[j][y1 - 1]) {
                    System.out.println("NE");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("DA");
            }
        }


    }
}
