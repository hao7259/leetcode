package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77_组合 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        _77_组合 q = new _77_组合();
        System.out.println(q.combine(3, 5));


    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;

    }

    private void dfs(int cur, int n, int k) {
        if (temp.size() == k) {
            res.add(temp);
            return;
        }
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.removeLast();
        dfs(cur + 1, n, k);
        return;
    }
}
