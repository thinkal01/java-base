package com.note;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    @Test
    public void test() {
        Integer[] integers = {1, 2, 3};
        // 用的原数组，不能对List增删，只能查改
        List<Integer> list = Arrays.asList(integers);
        System.out.println(list);
        integers[0] = 0;
        // 读取最新数组值
        System.out.println(list);


        List<Integer> list2 = new ArrayList<>(integers.length);
        Collections.addAll(list2, new Integer[]{1, 2, 3});

        // 可修改list
        List<Integer> list3 = new ArrayList<>(Arrays.asList(integers));
    }

    @Test
    public void test2() {
        // 可修改
        List<Integer> intList = Arrays.stream(new int[]{1, 2, 3,}).boxed().collect(Collectors.toList());
        List<Integer> intList2 = Stream.of(new Integer[]{1, 2, 3}).collect(Collectors.toList());
        intList2.add(4);
    }

    @Test
    public void test3() {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        int[] copy = Arrays.copyOf(new int[]{1, 2, 3}, 2);
    }
}
