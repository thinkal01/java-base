package com.note.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Array01 {
    /**
     * 数组转list
     */
    @Test
    public void test() {
        Integer[] integers = {1, 2, 3};
        // 用的原数组，不能对List增删，只能查改
        List<Integer> list = Arrays.asList(integers);
        // 会修改list里面值
        integers[0] = 0;
        // 读取最新数组值
        System.out.println(list);

        // 可修改list
        List<Integer> list3 = new ArrayList<>(Arrays.asList(integers));
    }

    @Test
    public void test02() {
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, new Integer[]{1, 2, 3});
        System.out.println(list2);
    }

    @Test
    public void test2() {
        // int数组转list,可修改
        List<Integer> intList = Arrays.stream(new int[]{1, 2, 3,}).boxed().collect(Collectors.toList());
        // Integer数组转list
        List<Integer> intList2 = Stream.of(new Integer[]{1, 2, 3}).collect(Collectors.toList());
    }

    /**
     * 数组复制
     */
    @Test
    public void test3() {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        int[] copy = Arrays.copyOf(new int[]{1, 2, 3}, 2);
    }

}
