package com.note.problem;

/**
 * 已知一个字符串都是由左括号(和右括号)组成，判断该字符串是否是有效的括号组合。
 * 有效的括号组合:()(),(()),(()())
 * 无效的括号组合:(,()),((),()(()
 */
public class Problem_02_ParenthesesProblem {

    public static boolean isValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }

        char[] chars = str.toCharArray();
        int status = 0;

        for (int i = 0; i < chars.length; i++) {
            // 非左右括号
            if (chars[i] != ')' && chars[i] != '(') {
                return false;
            }
            // 右括号,status-1
            if (chars[i] == ')' && --status < 0) {
                return false;
            }
            // 左括号,status+1
            if (chars[i] == '(') {
                status++;
            }
        }

        return status == 0;
    }

    /**
     * 题目进阶：
     * 已知一个字符串都是由左括号(和右括号)组成，返回最长有效括号子串的长度。
     * @param str
     * @return
     */
    public static int maxLength(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length];
        int pre = 0;
        int res = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        String str1 = "((())())";
        System.out.println(isValid(str1));
        System.out.println(maxLength(str1));

        String str2 = "(())(()(()))";
        System.out.println(isValid(str2));
        System.out.println(maxLength(str2));

        String str3 = "()(()()(";
        System.out.println(isValid(str3));
        System.out.println(maxLength(str3));
    }
}
