package com.note.problem;

import java.util.Scanner;
import java.util.Stack;

/**
 * 如果两个岗哨之间山峰,高度不大于这两座山峰,则可以观察到另一方
 * 相邻岗哨可以观察到
 * 求能相互观察到的岗哨对数
 */
public class Problem_09_MountainsAndFlames {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(communications(arr));
        }
    }

    public static int nextIndex(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    public static long getInternalSum(int n) {
        // C(n,2)
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    public static class Pair {
        public int value;
        public int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public static long communications(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int size = arr.length;
        int maxIndex = 0;
        // 计算数组最大值下标
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }

        int value = arr[maxIndex];
        int index = nextIndex(size, maxIndex);
        long res = 0L;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));

        /**
         * 栈是有序的
         * 大于栈顶元素弹栈
         * 小于栈顶元素入栈
         */
        while (index != maxIndex) {
            value = arr[index];
            /**
             * 大于栈顶元素,弹出,并计算栈顶观察到的岗哨数
             */
            while (!stack.isEmpty() && stack.peek().value < value) {
                int times = stack.pop().times;
                // res += getInternalSum(times) + times;
                // res += stack.isEmpty() ? 0 : times;
                res += getInternalSum(times) + times * 2;
            }
            if (!stack.isEmpty() && stack.peek().value == value) {
                stack.peek().times++;
            } else {
                stack.push(new Pair(value));
            }
            index = nextIndex(size, index);
        }

        /**
         * 处理栈中剩余有序元素
         */
        while (!stack.isEmpty()) {
            int times = stack.pop().times;
            res += getInternalSum(times);
            // 当前不是最后一个元素,也就是不是最大的元素
            if (!stack.isEmpty()) {
                res += times;
                if (stack.size() > 1) {
                    res += times;
                } else {
                    // 倒数第二个元素,第二大的元素
                    // 如果最大元素只有一个,那么左右看到都是同一座岗哨,只加一次即可
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }

        return res;
    }
}