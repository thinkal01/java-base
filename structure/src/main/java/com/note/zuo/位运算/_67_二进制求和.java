package com.note.zuo.位运算;

import java.math.BigInteger;

/**
 * leetcode-cn.com/problems/add-binary/
 */
public class _67_二进制求和 {
    public static void main(String[] args) {
        System.out.println(new _67_二进制求和().addBinary("11", "1"));
        int a = 123;
        int yushu = 0;
        String sum = "";
        while (true) {
            yushu = a % 10;
            sum = yushu + sum + " ";
            a = a / 10;
            if (a == 0) {
                break;
            }
        }
        sum = sum + "aa";
        System.out.println(sum);
    }

    /**
     * 采用的是位运算
     *  先是a ^ b
     *  然后a & b
     *  再对上面的两个结果看成新的
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }



    /**
     * 以十进制的思想来计算
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }


    /**
     * 自已的方法 太慢了 虽然可以通过运行
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int alength = a.length();
        int blength = b.length();
        int max = alength > blength ? alength : blength;
        if (alength < max) {
            for (int i = 0; i < max - alength; i++) {
                a = '0' + a;
            }
        } else {
            for (int i = 0; i < max - blength; i++) {
                b = '0' + b;
            }
        }
        char x = '0';
        char y = '1';
        char add = '0';
        String result = "";
        int zeroOfsum = 0;
        for (int i = max - 1; i >= 0; i--) {

            x = a.charAt(i);
            y = b.charAt(i);
            if (x == '0') zeroOfsum++;
            if (y == '0') zeroOfsum++;
            if (add == '0') zeroOfsum++;
            if (zeroOfsum == 3) {
                add = '0';
                result = '0' + result;
            } else if (zeroOfsum == 2) {
                add = '0';
                result = '1' + result;
            } else if (zeroOfsum == 1) {
                add = '1';
                result = '0' + result;
            } else {
                add = '1';
                result = '1' + result;
            }
            zeroOfsum = 0;
        }
        if (add == '1') {
            result = '1' + result;
        }
        return result;
    }
}
