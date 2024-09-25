package practice2;

import java.util.Scanner;

public class demo_数的三次方根 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double l;
        double r;
        if (a > 0) {
            l = 0;
            r = a;
        } else if (a < 0) {
            l = a;
            r = 0;
        } else {
            System.out.printf("%.6f", 0.0);
            return;
        }
        while (r - l > 1e-7) {
            double mid = (l + r) / 2;
            if (Math.pow(mid, 3) >= a) r = mid;
            else l = mid;
        }
        System.out.printf("%.6f", l);
    }
}
