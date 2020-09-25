package com.note.collection.LinkedList.MyCollection;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedListTest {
    //测试
    public static void main(String[] args) {
        System.out.println("------init-------");
        MyLinkedList<Integer> mylinkedList = new MyLinkedList<>();
        mylinkedList.add(2);
        mylinkedList.add(10);
        mylinkedList.add(1);
        mylinkedList.add(9);
        mylinkedList.add(20);
        mylinkedList.add(555);

        print(mylinkedList);
        System.out.println("------remove(2)-------");
        mylinkedList.remove(2);
        print(mylinkedList);
        System.out.println("------indexOf(10)&set(0,0)-------");
        System.out.println("index-->" + mylinkedList.indexOf(10));
        mylinkedList.set(0, 0);
        print(mylinkedList);

        System.out.println("-------------iterator--------------");
        Iterator<Integer> iterator = mylinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next-->" + iterator.next());
        }

        System.out.println("-------------iteratorList--------------");
        ListIterator<Integer> iteratorList = mylinkedList.listIterator(0);
        iteratorList.add(88);
        while (iteratorList.hasNext()) {
            System.out.println("iteratorList.next-->" + iteratorList.next());
        }
        iteratorList.add(100);
        System.out.println("-------------iteratorList1.add--------------");
        //使用完后必须重新new
        ListIterator<Integer> iteratorList1 = mylinkedList.listIterator(0);
        while (iteratorList1.hasNext()) {
            int i = iteratorList1.next();
            if (i == 555) {
                System.out.println("i==555");
                iteratorList1.remove();
            } else {
                System.out.println("iteratorList.next-->" + i);
            }
        }


        System.out.println("-------------foreach--------------");
        for (Integer data : mylinkedList) {
            System.out.println("data-->" + data);
        }

        System.out.println("-------------iterator--------------");
        //抛异常:java.util.ConcurrentModificationException
        //在迭代时删除元素必须使用iterator自身的删除方法,使用MylinkedList的
        //删除方法将会触发快速失败机制
        Iterator<Integer> it = mylinkedList.iterator();
        while (it.hasNext()) {
            mylinkedList.remove(new Integer(100));
            Integer value = it.next();
            if (value == 100) {
                System.out.println("该集合含100!");
            } else {
                System.out.println("该集合不含100!");
            }
        }
    }

    public static void print(MyLinkedList mylinkedList) {
        for (int i = 0; i < mylinkedList.size(); i++) {
            System.out.println("i->" + mylinkedList.get(i));
        }
    }

}
