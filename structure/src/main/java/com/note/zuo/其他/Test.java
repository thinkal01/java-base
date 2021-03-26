package com.note.zuo.其他;

public class Test {
    public static void main(String[] args) {
        new Test().testArray(new int[]{1, 2, 3, 4});
    }
    public void testArray(int[] num) {
        //这个num是我要传进来的 你在方法中直接用
        //相当于你在方法中这样的
        int[] a = new int[]{1, 2, 3, 4};
    }
}
