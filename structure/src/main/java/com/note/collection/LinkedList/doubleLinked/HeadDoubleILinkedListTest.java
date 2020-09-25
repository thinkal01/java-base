package com.note.collection.LinkedList.doubleLinked;

import org.junit.Test;

public class HeadDoubleILinkedListTest {
    @Test
    public void test01() {
        String[] letters = {"A", "B", "C", "D", "Z", "E", "F"};
        HeadDoubleILinkedList<String> list = new HeadDoubleILinkedList<>(letters);

        System.out.println("list.get(3)->" + list.get(3));
        System.out.println("list:" + list.toString());

        System.out.println("list.add(4,Y)—>" + list.add(0, "Y"));
        System.out.println("list:" + list.toString());
        System.out.println("list.add(Z)—>" + list.add("Z"));
        System.out.println("list:" + list.toString());


        System.out.println("list.contains(Z)->" + list.contains("Z"));
        System.out.println("list.set(4,P)-->" + list.set(4, "P"));
        System.out.println("list:" + list.toString());

        System.out.println("list.remove(6)-->" + list.remove(6));
        // System.out.println("list.remove(Z)->" + list.removeAll("Z"));
        System.out.println("list:" + list.toString());
    }

    @Test
    public void test02() {
        HeadDoubleILinkedList<String> list = new HeadDoubleILinkedList<>();
        list.add("abc");
        list.add("def");

        return;
    }
}
