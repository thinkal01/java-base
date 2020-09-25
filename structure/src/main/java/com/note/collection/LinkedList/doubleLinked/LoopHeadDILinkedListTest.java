package com.note.collection.LinkedList.doubleLinked;

import org.junit.Test;

public class LoopHeadDILinkedListTest {
    @Test
    public void test01() {
        String[] letters = {"A", "B", "C", "D", "Z", "E", "F"};
        LoopHeadDILinkedList<String> list = new LoopHeadDILinkedList<>(letters);

        System.out.println("init list-->" + list.toString());

        System.out.println("list.get(3)->" + list.get(3));
        System.out.println("list:" + list.toString());

        System.out.println("list.add(4,Y)—>" + list.add(4, "Y"));
        System.out.println("list:" + list.toString());
        System.out.println("list.add(Z)—>" + list.add("Z"));
        System.out.println("list:" + list.toString());

        System.out.println("list.contains(Z)->" + list.contains("Z"));
        System.out.println("list.set(4,P)-->" + list.set(4, "P"));
        System.out.println("list:" + list.toString());

        System.out.println("list.remove(3)-->" + list.remove(3));
        System.out.println("list.remove(Z)->" + list.removeAll("Z"));
        System.out.println("list:" + list.toString());
    }

    @Test
    public void test02() {
        LoopHeadDILinkedList<String> list = new LoopHeadDILinkedList<>();
        list.add("a");
        list.add("b");
        list.add("d");
        list.add(2, "c");

        list.remove(1);
        return;
    }
}
