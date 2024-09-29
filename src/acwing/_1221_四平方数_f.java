package acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class pair {
    int num1;
    int num2;

    public pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

public class _1221_四平方数_f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //
        for (int a = 0; a * a * 4 <= n; a++) {
            for (int b = a; b * b * 3 + a * a <= n; b++) {
                for (int c = b; c * c * 2 + b * b + a * a <= n; c++) {
                    int d = (int) Math.sqrt(n - a * a - b * b - c * c);
                    if (a * a + b * b + c * c + d * d == n) {
                        System.out.println(a + " " + b + " " + c + " " + d);
                        return;
                    }
                }
            }
        }
    }


    public void   fun2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, pair> map = new HashMap<>();
        for (int i = 0; i * i <= n / 2; i++) {
            for (int j = i; i * i + j * j <= n; j++) {
                map.put(i * i + j * j, new pair(i, j));
            }
        }
        for (int k = 0; k * k < n / 2; k++) {
            for (int w = k; k * k + w * w <= n; w++) {
                int temp;
                pair pair = map.get(n - (temp = k * k + w * w));
                if (pair == null || temp > n - temp) {
                    continue;
                } else if (pair.num1 * pair.num1 + pair.num2 + pair.num2 + k * k + w * w == n) {
                    System.out.println(k + " " + w + " " + pair.num1 + " " + pair.num2);
                    return;
                }
            }
        }
    }

    public static void fun1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = (int) Math.sqrt(n);
        boolean flag = false;
        for (int i = 0; i * i < num; i++) {
            for (int j = 0; j * j + i * i < num; j++) {
                for (int k = 0; i * i + j * j + k * k <= num; k++) {
                    int i1 = n - (i * i + j * j + k * k);
                    if (Math.pow((int) Math.sqrt(i1), 2) == i1) {
                        System.out.println(i + " " + j + " " + k + " " + (int) Math.sqrt(i1));
                        flag = true;
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
            if (flag) break;
        }
    }


}
