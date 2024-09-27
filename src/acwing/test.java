package acwing;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num= (int) Math.sqrt(num1)+1;
        for (int j = 0; j < num; j++) {
            for (int i = 0; i < num; i++) {
                for (int k = 0; k < num; k++) {
                    for (int l = 0; l < num; l++) {
                        if (j*j+i*i+k*k+l*l == num1) {
                            flag = true;
                            System.out.println(j+" "+i+" "+k+" "+l);
                            break;
                        }
                    }
                    if (flag) {break;}
                }if (flag) {break;}
            }if (flag) {break;}
        }
    }
}
