package com.note.leetcode.动态规划;

import org.junit.Test;

import java.util.Arrays;

public class _1235_规划兼职工作 {

    @Test
    public void test() {
        System.out.println(jobScheduling(new int[]{6, 15, 7, 11, 1, 3, 16, 2}, new int[]{19, 18, 19, 16, 10, 8, 19, 8}, new int[]{2, 9, 1, 19, 5, 7, 3, 19}));
    }

    /**
     * https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling/
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int length = startTime.length;
        Job[] jobs = new Job[length];
        for (int i = 0; i < length; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs[i] = job;
        }
        Arrays.sort(jobs, (j1, j2) -> (j1.end - j2.end));

        int[] dp = new int[length];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < length; i++) {
            //1.先找出dp[i-1],和profit[i]的利益最大值。得出第一步dp[i]
            dp[i] = Math.max(dp[i - 1], jobs[i].profit);

            //2.再找出离i最近的不重合的j，取dp[j]+profit[i],第一步的dp[i]，两者之间的最大值
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    //第一次找到j时得出的最大值，一定是dp[i]的最大值，
                    //再往更小的j寻找得到的都不是最大值，所以此处break。
                    dp[i] = Math.max(dp[j] + jobs[i].profit, dp[i]);
                    break;
                }
            }
        }

        return dp[length - 1];
    }

    class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}