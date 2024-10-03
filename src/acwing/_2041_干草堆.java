package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class _2041_干草堆 {
    /*
    贝茜对她最近在农场周围造成的一切恶作剧感到抱歉，她同意帮助农夫约翰把一批新到的干草捆堆起来。开始时，共有 N个空干草堆，编号 1∼N
    约翰给贝茜下达了 K个指令，每条指令的格式为 A B，这意味着贝茜要在 A..B范围内的每个干草堆的顶部添加一个新的干草捆。
    例如，如果贝茜收到指令 10 13，则她应在干草堆 10,11,12,13中各添加一个干草捆。

    在贝茜完成了所有指令后，约翰想知道 N个干草堆的中值高度——也就是说，如果干草堆按照高度从小到大排列，位于中间的干草堆的高度。

    方便起见，N一定是奇数，所以中间堆是唯一的。

    请帮助贝茜确定约翰问题的答案。

    输入格式
    第一行包含 N和 K。

    接下来 K行，每行包含两个整数 A,B，用来描述一个指令。

    输出格式
    输出完成所有指令后，N个干草堆的中值高度。

    7 4
    5 5
    2 4
    4 6
    3 5

    1
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] original = new int[n + 2];
        int[] diff = new int[n + 2];
        for (int i = 1; i <= k; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            diff[l] += 1;
            diff[r + 1] -= 1;
        }
        for (int i = 1; i <= n; i++) {
            original[i] = original[i - 1]+diff[i];
        }
        Arrays.sort(original);
        System.out.println(original[original.length/2+1]);

    }


}
