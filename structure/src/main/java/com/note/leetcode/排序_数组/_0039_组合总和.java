package com.note.leetcode.排序_数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0039_组合总和 {

    @Test
    public void test() {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        return;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (idx == candidates.length) return;

        dfs(candidates, target, idx + 1);

        int i = 1;
        for (; i <= target / candidates[idx]; ++i) {
            combination.add(candidates[idx]);
            dfs(candidates, target - candidates[idx] * i, idx + 1);
        }

        for (int j = 0; j < i - 1; ++j) {
            combination.remove(combination.size() - 1);
        }
    }
}
