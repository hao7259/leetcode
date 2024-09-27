package acwing;

import java.util.ArrayList;
import java.util.Scanner;

public class demo_前缀和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int q_num = sc.nextInt();
        int[] arr = new int[num + 1];
        ArrayList<Integer> list = new ArrayList<>();
        arr[0] = 0;
        for (int i = 1; i <= num; i++) {
            arr[i] = sc.nextInt() + arr[i - 1];
        }
        for (int i = 1; i <= q_num; i++) {
            int q1 = sc.nextInt();
            int q2 = sc.nextInt();
            list.add(arr[q2] - arr[q1 - 1]);
        }
        for(int i:list){
            System.out.println(i);
        }
    }

}
