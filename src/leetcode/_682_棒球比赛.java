package leetcode;

import java.util.ArrayList;

public class _682_棒球比赛 {
    public static int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (String s : operations) {
            switch (s.charAt(0)) {
                case 'C':
                    sum -= list.getLast();
                    list.removeLast();
                    break;
                case 'D':
                    list.add(list.getLast() << 1);
                    sum += list.getLast();
                    break;
                case '+':
                    list.add(list.getLast()+list.get(list.size() - 2));
                    sum += list.getLast();
                    break;
                default:
                    list.add(Integer.parseInt(s));
                    sum += list.getLast();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] operations = {"1","D","D","D"};
        System.out.println(calPoints(operations));
    }
}
