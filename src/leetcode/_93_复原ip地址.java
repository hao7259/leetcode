package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _93_复原ip地址 {
    public static void main(String[] args) {
        _93_复原ip地址 q = new _93_复原ip地址();
        List<String> list = q.restoreIpAddresses("192168101");
        System.out.println(list);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        fun(res, s, 0, 0, new StringBuilder());
        return res;
    }

    private void fun(List<String> res, String s, int start, int cur, StringBuilder sb) {
        // 如果已经分了4段，并且已经用完了所有字符，则是一个有效的IP地址
        if (cur == 4 && start == s.length()) {
            // 删除最后一个点
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            // 恢复最后一个点
            sb.append(".");
            return;
        }
        // 如果已经分了4段，但是没有用完所有字符，或者没有分4段但是已经用完了所有字符，都不是有效的IP地址
        if (cur == 4 || start >= s.length()) {
            return;
        }

        // 检查0的情况
        if (s.charAt(start) == '0') {
            sb.append("0");
            sb.append(".");
            fun(res, s, start + 1, cur + 1, sb);
            // 删除追加的"0."
            sb.delete(sb.length() - 2, sb.length());
            return;
        }

        // 尝试每一种可能的长度
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break; // 剩余字符不足
            String segment = s.substring(start, start + i);
            if (Integer.parseInt(segment) > 255) break; // 段超过255不合法
            sb.append(segment);
            sb.append(".");
            fun(res, s, start + i, cur + 1, sb);
            // 删除追加的"segment."
            sb.delete(sb.length() - i - 1, sb.length());
        }
    }


//    public List<String> restoreIpAddresses(String s) {
//        List<String> res = new ArrayList<>();
//        res = fun(res, s, 0, 0, new StringBuilder());
//        return res;
//
//
//    }
//
//
//    private List<String> fun(List<String> res, String s, int count, int cur, StringBuilder sb) {
////        if (s.length()>count&&s.charAt(count)=='0') return res;
////        if (s.charAt(count) == '0' && count < s.length() - 1) return res;
//        if ((cur == 3)) {
//            if ((s.length() - count <= 3)) {
//                sb.append(s, count, s.length());
//                res.add(sb.toString());
//                sb.delete(count,s.length());
//            }
//            return res;
//        }
//        if (cur == 1 && (s.length() - count > 9 || s.length() - count < 3)) return res;
//        if (cur == 2 && (s.length() - count > 6 || s.length() - count < 2)) return res;
//
//        //加一个字符
//        sb.append(s.charAt(count));
//        sb.append(".");
//        res = fun(res, s, count + 1, cur + 1, sb);
//        sb.delete(sb.length() - 2, sb.length());
//
//        //加2个字符
//        sb.append(s, count, count + 2);
//        sb.append(".");
//        res = fun(res, s, count + 2, cur + 1, sb);
//        sb.delete(sb.length() - 3, sb.length());
//
//        //判断是不是超过255;
//        if (Integer.parseInt(s.substring(count, count + 3))>255) return res;
//
//        //加3个字符
//        sb.append(s, count, count + 3);
//        sb.append(".");
//        res = fun(res, s, count + 3, cur + 1, sb);
//        sb.delete(sb.length() - 4, sb.length());
//
//
//        return res;


}


