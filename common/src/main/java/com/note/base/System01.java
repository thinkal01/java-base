package com.note.base;

import org.junit.Test;

public class System01 {

    @Test
    public void test() {
        /**
         * 系统环境变量
         */
        // 项目路径
        // C:\Users\Administrator\Desktop\workspace\java-base\common
        System.out.println(System.getProperty("user.dir"));
        // 家目录
        // C:\Users\Administrator
        System.out.println(System.getProperty("user.home"));
    }
}
