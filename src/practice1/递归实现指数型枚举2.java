package practice1;

import java.util.ArrayList;
import java.util.List;


public class 递归实现指数型枚举2 {
    /**
     * note:下面被注释的方法在输入>=10时会出错
     */

    List<Integer> list = new ArrayList<>();

    public void fun1(int start, int end) {
        if (start > end) {
            for(int i :list){
                System.out.print(i+" ");
            }
            System.out.println();
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

    public void fun2(int start) {
        fun1(1, start);
        System.out.println(" ");
    }
    public static void main(String[] args) {
        递归实现指数型枚举2 q = new 递归实现指数型枚举2();
        q.fun2(10);

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
