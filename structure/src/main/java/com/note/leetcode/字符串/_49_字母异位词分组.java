package com.note.leetcode.字符串;

import java.util.*;

/**
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class _49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> ans = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                ++count[c - 'a'];
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; ++i) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }

        return new ArrayList<>(ans.values());
    }

}
