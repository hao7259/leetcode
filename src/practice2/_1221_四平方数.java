package practice2;

import java.util.Scanner;

public class _1221_四平方数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = (int) Math.sqrt(n);
        boolean flag = false;
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                for (int k = 0; k <= num; k++) {
                    int i1 = n - (i * i + j * j + k * k);
                    if (Math.pow((int) Math.sqrt(i1), 2) == i1) {
                        System.out.println(i + " " + j + " " + k + " " + (int) Math.sqrt(i1));
                        flag = true;
                    }
                    if (flag) break;
                }if (flag) break;
            }if (flag) break;
        }


    }


}
