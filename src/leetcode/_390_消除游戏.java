package leetcode;

import java.util.ArrayList;

/**
 *
 */
public class _390_消除游戏 {
    public static int lastRemaining(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.println(list);
        //T -> 从左删除
        //F -> 从右删除
        boolean flag = true;
        while (list.size() > 1) {
            if (flag&&list.size()%2==0) {
                list=del2(list);
                System.out.println(list);
            }
            else
            {
                list = del1(list);
                System.out.println(list);
            }
            flag = !flag;
        }
        return list.get(0);
    }

    //奇数 || 偶数从右删
    public static ArrayList<Integer> del1(ArrayList<Integer> list) {
        for (int i = list.size()-1; i >= 0; i-=2) {
            list.remove(i);
        }
        return list;
    }
    //偶数 从左删
    public static ArrayList<Integer> del2(ArrayList<Integer> list) {
        for (int i = list.size()-2; i >= 0; i-=2) {
            list.remove(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int a = lastRemaining(50);
        System.out.println(a);
    }
}
