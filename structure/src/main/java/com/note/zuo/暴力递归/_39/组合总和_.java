package com.note.zuo.暴力递归._39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 组合总和_ {

    public static void main(String[] args) {
        int[] candidates= new int[]{2,3,6,7};
        int target = 7;
        System.out.println(new 组合总和_().combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        permuteSum(candidates,0, list, cur, target);
        return list;
    }

    public void permuteSum(int[] candidates,int begin,List<List<Integer>> list,List<Integer> cur,int target){
        if (target == 0) {
            List<Integer> curcopy = new ArrayList<>();
            for (int j = 0; j < cur.size(); j++) {
                curcopy.add(cur.get(j));
            }
            list.add(curcopy);
        }

        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
                cur.add(candidates[i]);
                permuteSum(candidates,i,list,cur,target-candidates[i]);
                cur.remove(Integer.valueOf(candidates[i]));
            }
        }

}
