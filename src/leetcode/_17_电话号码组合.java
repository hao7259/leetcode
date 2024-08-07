package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码组合 {


    int anserlen;

    public static void main(String[] args) {
        _17_电话号码组合 qq = new _17_电话号码组合();
        List<String> list = qq.letterCombinations("");
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        anserlen = digits.length();
        List<String> list = new ArrayList<>();
        fun(list, new StringBuilder(), digits, 0);
        return list;


    }

    private void fun(List<String> list, StringBuilder curStr, String digits, int start) {
        if (anserlen == curStr.length()) {
            list.add(curStr.toString());
            return;
        }
        switch (digits.charAt(start)) {
            case '2': {
                curStr.append("a");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("b");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("c");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
            case '3': {
                curStr.append("d");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("e");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("f");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
            case '4': {
                curStr.append("g");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("h");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("i");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
            case '5': {
                curStr.append("j");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("k");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("l");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
            case '6': {
                curStr.append("m");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("n");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("o");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
            case '7': {
                curStr.append("p");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("q");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("r");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("s");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
            case '8': {
                curStr.append("t");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("u");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("v");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
            case '9': {
                curStr.append("w");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("x");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("y");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                curStr.append("z");
                fun(list, curStr, digits, ++start);
                curStr.deleteCharAt(curStr.length() - 1);
                start--;
                break;
            }
        }

    }

}
