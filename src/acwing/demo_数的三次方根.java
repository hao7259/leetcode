package acwing;

import java.util.Scanner;

public class demo_数的三次方根 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double l=-10000;
        double r=10000;
        while (r - l > 1e-7) {
            double mid = (l + r) / 2;
            if (Math.pow(mid, 3) >= a) r = mid;
            else l = mid;
        }
        System.out.printf("%.6f", l);
    }
}
