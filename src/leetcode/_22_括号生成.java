package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    List<String> list;

    public static void main(String[] args) {
        _22_括号生成 q = new _22_括号生成();
        List<String> list1 = q.generateParenthesis(3);
        System.out.println(list1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list,new StringBuilder(), 0, 0, n);
        return list;
    }

    private void generate(List<String> list,StringBuilder cur, int open, int close, int count) {
        if (cur.length() == count * 2) {
            list.add(cur.toString());
            return;
        }
        if (open < count ) {
            cur.append("(");
            generate(list,cur, open + 1, close, count);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            generate(list,cur, open, close + 1, count);
            cur.deleteCharAt(cur.length() - 1);
        }

    }
}
