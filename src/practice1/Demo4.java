package practice1;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] arr = new int[i + 1];
        for (int j = 1; j <= i; j++) {
            arr[j] = j;
        }
        dfs(arr,new StringBuilder(),1);


    }

    private static void dfs(int[] arr, StringBuilder stringBuilder, int count) {
        if (arr.length == count) {
            System.out.println(stringBuilder.toString());
            return;
        }
        //先选择此数字
        stringBuilder.append(arr[0]).append(" ");
        dfs(arr, stringBuilder, count + 1);
        //恢复现场
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        //先选择后面的数字
        dfs(arr, stringBuilder, count + 1);
        stringBuilder.append(arr[0]).append(" ");
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    }
}
