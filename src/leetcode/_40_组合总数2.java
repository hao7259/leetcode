package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_组合总数2 {
    List<List<Integer>> res;
    List<Integer> temp;
    boolean[] arr;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        arr = new boolean[candidates.length];
        Arrays.sort(candidates);
        fun(candidates, target, 0);
        return res;
    }

    public void fun(int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //选择当前数字
        if (target >= candidates[index]) {
            if (arr[index]) {return;}
            arr[index] = true;
            temp.add(candidates[index]);
            fun(candidates, target - candidates[index], index);
            temp.removeLast();
        }
        //不选择当前数字，直接跳过
        fun(candidates, target, index + 1);

    }
}
