package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _39_组合总数 {
    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
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
        //不选择当前数字，直接跳过
        fun(candidates, target, index + 1);
        //选择当前数字
        if (target>=candidates[index]) {
            temp.add(candidates[index]);
            fun(candidates, target-candidates[index], index);
            temp.removeLast();
        }
    }

    /*
      @param candidates:题目已知
     * @param target:题目已知
     * @param addIndex:要添加的是题目给出数组的哪一个元素（下标）
     */
//    private void fun(int[] candidates, int target, int addIndex) {
//        if (curSum == target) {
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//        if (curSum > target) {
//            return;
//        } else {
//            for (int i = 0; i < candidates.length; i++) {
//                if (curLimit == null) {
//                    curLimit = candidates[i];
//                }
//                int backup = curLimit;
//                if (candidates[i] >= backup) {
//                    temp.add(candidates[i]);
//                    curSum += candidates[i];
//                    fun(candidates, target, i);
//                    temp.removeLast();
//                    curSum -= candidates[i];
//                }
//                curLimit = null;
//
//            }
//        }
//
//    }
}
