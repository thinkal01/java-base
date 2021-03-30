package com.note.ms;

import java.util.*;

/**
 * 数组墙问题
 */
public class FindMaxRectangle {

    public static void main(String[] args) {
        // 随机生成数组
        int[] array = generateArray(20);
        // 将数组打印出来
        System.out.println("当前数组：" + arrayToString(array));
        // 打印数组墙
        printArray(array);
        // 输出最大矩形墙的面积
        System.out.println("数组最大矩形墙的面积为：" + findMax(array));
    }

    /**
     * 查找最大矩形墙的面积
     */
    private static int findMax(int[] array) {
        int[] copy = new int[array.length]; // 记录运行时数组中的值
        int[] area = new int[array.length]; // 记录最大矩形墙的面积
        Queue<List<Coordinate>> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
            area[i] = 0;
        }

        queue.offer(divideArray(copy));
        while (!queue.isEmpty()) {
            List<Coordinate> coordinates = queue.poll();
            // 没有任何有效的子数组
            if (coordinates.size() == 0)
                break;
            for (Coordinate coordinate : coordinates) {
                for (int i = coordinate.getStartIndex(); i < coordinate.getEndIndex(); i++) {
                    if (copy[i] > 0) {
                        // 减去最小值minValue
                        copy[i] -= coordinate.getMinValue();
                    }
                    // 计算子数组对应的最大矩阵墙面积
                    int value = (array[i] - copy[i]) * (coordinate.getEndIndex() - coordinate.getStartIndex());
                    // 更新最大矩阵墙的面积
                    area[i] = Math.max(value, area[i]);
                }
            }
            queue.offer(divideArray(copy));
        }

        // 查找最大的矩阵墙的面积
        int maxArea = 0;
        for (int i = 0; i < area.length; i++) {
            if (maxArea < area[i]) {
                maxArea = area[i];
            }
        }

        return maxArea;
    }

    /**
     * 将数组按照0元素切分成多个子数组，子数组用Coordinate对象来记录
     */
    private static List<Coordinate> divideArray(int[] array) {
        List<Coordinate> coordinates = new ArrayList<>();
        int startIndex = -1, endIndex = -1, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (startIndex == -1) {
                    startIndex = i;
                }
                if (array[i] < minValue) {
                    minValue = array[i];
                }
            } else {
                if (startIndex != -1) {
                    endIndex = i;
                    coordinates.add(new Coordinate(startIndex, endIndex, minValue));
                    startIndex = -1;
                    minValue = Integer.MAX_VALUE;
                }
            }
        }
        if (startIndex != -1) {
            coordinates.add(new Coordinate(startIndex, array.length, minValue));
        }
        return coordinates;
    }

    /**
     * 随机生成指定长度的数组
     */
    private static int[] generateArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int value = random.nextInt(10);
            if (value < 0) {
                value = 0;
            }
            array[i] = value;
        }
        return array;
    }

    /**
     * 打印成数组墙
     */
    private static void printArray(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        for (int i = max; i > 0; i--) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] >= i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 将数组转换成字符串
     */
    private static String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i != array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * 用来记录子数组信息
     */
    static class Coordinate {
        /**
         * @param startIndex 数组的起始下标
         * @param endIndex   数组的结束下标（不包含）
         * @param minValue   数组中的最小值
         */
        public Coordinate(int startIndex, int endIndex, int minValue) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.minValue = minValue;
        }

        private int startIndex; // 数组的起始下标
        private int endIndex; // 数组的结束下标（不包含）
        private int minValue; // 数组中的最小值

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public int getMinValue() {
            return minValue;
        }
    }
}