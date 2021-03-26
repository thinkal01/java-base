package com.note.zuo.其他;

/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class _66_加一 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] == 0) return digits;
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
