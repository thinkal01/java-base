package com.note.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Collection01 {

    @Test
    public void test02() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        // 集合元素使用逗号连接
        String join = StringUtils.join(set, ",");
        System.out.println(join);
    }
}
