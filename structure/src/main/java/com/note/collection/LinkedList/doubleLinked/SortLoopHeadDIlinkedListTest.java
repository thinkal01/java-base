package com.note.collection.LinkedList.doubleLinked;

import org.junit.Test;

public class SortLoopHeadDIlinkedListTest {

    @Test
    public void test01() {
        SortLoopHeadDIlinkedList<Integer> list = new SortLoopHeadDIlinkedList<>();
        list.add(50);
        list.add(40);
        list.add(80);
        list.add(20);
        System.out.println("init list-->" + list.toString());
    }
}
