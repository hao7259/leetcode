package practice1;

import java.util.Scanner;

/**
 * 小明正在玩一个“翻硬币”的游戏。
 * 桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。
 * 比如，可能情形是：**oo***oooo
 * 如果同时翻转左边的两个硬币，则变为：oooo***oooo
 * 现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,那么对特定的局面，最少要翻动多少次呢？
 * 我们约定：把翻动相邻的两个硬币叫做一步操作。
 * 输入格式
 * 两行等长的字符串，分别表示初始状态和要达到的目标状态。
 * 输出格式
 * 一个整数，表示最小操作步数
 * 数据范围
 * 输入字符串的长度均不超过100。
 * 数据保证答案一定有解。
 * 输入样例1：
 * **********
 * o****o****
 * 输出样例1：
 * 5
 * 输入样例2：
 * *o**o***o***
 * *o***o**o***
 * 输出样例2：
 * 1
 */
@SuppressWarnings({"all"})
//使用贪心测略，直接找到不一样的地方对相邻的两个硬币进行饭
public class 翻硬币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入原始状态");
        StringBuffer sb1 = new StringBuffer(sc.next()); //开始状态
        System.out.println("请输入您想要的状态");
        StringBuffer sb2 = new StringBuffer(sc.next()); //目的状态
        int n = 0; //反转次数
        changes2(sb1,sb2,n);
    }

    /**
     * 优化后
     * 重点！！贪心   以及  StringBuffer/StringBuilder
     * 贪心 ： 因为每一个硬币不是正就是反，不对就换，不需要考虑其他的，只要换队就行.
     * 字符串的选择：String一旦定义不可改变，必须用新的变量来接受，但 StringBuffer/StringBuilder 不需要
     * 如果把最后一个反转过一次后，全部还是不相等，现在就相当于一个新的字符串只有第一个不相等，不会出现这种情况，不用考虑了，永远都是偶数倍的地方有不同
     * @param begin
     * @param end
     * @param count
     */
    public static void changes2(StringBuffer begin,StringBuffer end,int count){
        int length = begin.length();
        char c = '*';
        char h = 'o';
        if(!begin.equals(end))
        //开始操作，换 j 下标的以及 j + 1 下标的元素
        for (int j = 0; j < length - 1; j++) {
            if (begin.charAt(j) != end.charAt(j)) {
                count++;
                if (begin.charAt(j) == h)       begin.setCharAt(j, c);  //第一个硬币进行操作
                else if (begin.charAt(j) == c)  begin.setCharAt(j, h);  //第一个硬币进行操作
                if (begin.charAt(j + 1) == h) begin.setCharAt(j + 1, c); //第二个硬币进行操作
                else if (begin.charAt(j + 1) == c) begin.setCharAt(j + 1, h); //第二个硬币进行操作
            }
            else if(begin.equals(end)) break; //可以提前结束，时间复杂度降低，不需要让每一个字符进行比较
        }
        System.out.println(count);
        System.out.println(begin);
    }

    public static void changes(StringBuffer begin,StringBuffer end,int count){
        int le = begin.length();
        char c = '*';
        char h = 'o';
        int num = 0;
        if(begin.equals(end)) {
            System.out.println(count);
        }else {//两者不相等
            /**
             * 先找到第一个字符不相同的下标，从该下标开始进行反转，每次都只从i和i+1进行反转
             * 如果把最后一个反转过一次后，全部还是不相等，现在就相当于一个新的字符串只有第一个不相等，不会出现这种情况，不用考虑了，永远都是偶数倍的地方有不同
             */
            for (int i = 0; i < le; i++) {
                //找到第一个不相等的下标了
                if (begin.charAt(i) != end.charAt(i)) {
                    num = i;
                    break;
                }
            }
            //开始操作，换 j 下标的以及 j + 1 下标的元素
            for (int j = num; j < le - 1; j++) {
                if (begin.charAt(j) != end.charAt(j)) {
                    count++; //能进if就肯定要操作一次
                    if (begin.charAt(j) == h) {
                        begin.setCharAt(j, c);
                        if (begin.charAt(j + 1) == h) begin.setCharAt(j + 1, c);
                        else if (begin.charAt(j + 1) == c) begin.setCharAt(j + 1, h);
                    } else if (begin.charAt(j) == c) {
                        begin.setCharAt(j, h);
                        if (begin.charAt(j + 1) == h) begin.setCharAt(j + 1, c);
                        else if (begin.charAt(j + 1) == c) begin.setCharAt(j + 1, h);
                    }
                }
            }
            System.out.println(count);
        }
    }

}
