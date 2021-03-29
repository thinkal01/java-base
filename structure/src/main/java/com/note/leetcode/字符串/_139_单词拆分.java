package com.note.leetcode.字符串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_单词拆分 {
    @Test
    public void test() {
        wordBreak("leetcode", new ArrayList<String>() {
            {
                add("leet");
                add("code");
            }
        });
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) return true;

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()), wordDict)) return true;
            }
        }

        return false;
    }

}
