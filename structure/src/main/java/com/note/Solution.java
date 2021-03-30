package com.note;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test() {
        System.out.println(partition("cdd"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>>[] dp = new ArrayList[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i] = new ArrayList<>();

            for (int j = 0; j <= i; ++j) {
                int left = j, right = i;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) break;
                    ++left;
                    --right;
                }

                if (left < right) continue;

                if (j == 0) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(0, i + 1));
                    dp[i].add(list);
                } else {
                    String str = s.substring(j, i + 1);
                    for (List<String> item : dp[j - 1]) {
                        List<String> temp = new ArrayList<>(item);
                        temp.add(str);
                        dp[i].add(temp);
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}
