package practice1;

import java.util.ArrayList;
import java.util.List;


public class 递归实现指数型枚举 {
    /**
     * note:下面被注释的方法在输入>=10时会出错
     */

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public void fun1(int start, int end) {
        if (start > end) {
            res.add(new ArrayList<>(list));
//            System.out.println(list);
        } else {
            //选择此数字
            list.add(start);
            fun1(start + 1, end);
            list.removeLast();
            //不选择此数字
            fun1(start + 1, end);
        }
    }

    public List<List<Integer>> fun2(int start) {
        res.add(new ArrayList<>());
        fun1(1, start);
        return res;
    }
    public static void main(String[] args) {
        递归实现指数型枚举 q = new 递归实现指数型枚举();
//        q.fun2(10);
        List<List<Integer>> s = q.fun2(15);
        for (List<Integer> l : s) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


//    StringBuilder str = new StringBuilder();
//    List<String> list = new ArrayList<>();
//
//    private void fun1(int i, int n) {
//        if (i > n) {
//            System.out.println(str);
//            list.add(str.toString());
//        } else {
//            //选择此数字
//            str.append(i).append(" ");
//            fun1(i + 1, n);
//            str = new StringBuilder(str.substring(0, str.length() - 2));
//            //不选择此数字
//            fun1(i + 1, n);
//        }
//    }
//    public List<String> fun2(int n) {
//        fun1(1, n);
//        list.add("");
//        System.out.println();
//        return list;
//    }



}
