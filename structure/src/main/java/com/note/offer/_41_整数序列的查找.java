package com.note.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出所有和为 S 的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class _41_整数序列的查找 {

    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        if (sum < 3) return list;

        int small = 1;
        int big = 2;
        while (small < (sum + 1) / 2) {
            int s = 0;
            for (int i = small; i <= big; ++i) {
                s += i;
            }

            if (s == sum) {
                for (int i = small; i <= big; ++i) {
                    tmpList.add(i);
                }

                List<Integer> copyList = new ArrayList<>();
                copyList.addAll(tmpList);
                list.add(copyList);
                tmpList.clear();
                ++small;
            } else if (s > sum) {
                ++small;
            } else {
                ++big;
            }
        }

        return list;
    }
}
