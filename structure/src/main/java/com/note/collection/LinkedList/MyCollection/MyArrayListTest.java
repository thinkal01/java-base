package com.note.collection.LinkedList.MyCollection;

import java.util.Iterator;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(2);
        myArrayList.add(10);
        myArrayList.add(1);
        myArrayList.add(9);

        print(myArrayList);
        System.out.println("-------------");
        myArrayList.remove(2);
        print(myArrayList);
        System.out.println("-------------");
        System.out.println("index-->" + myArrayList.indexOf(10));
        myArrayList.set(0, 0);
        print(myArrayList);

        System.out.println("-------------iterator--------------");
        Iterator iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next-->" + iterator.next());
        }

        System.out.println("-------------foreach--------------");
        for (Integer data : myArrayList) {
            System.out.println("data-->" + data);
        }
    }

    public static void print(MyArrayList myArrayList) {
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println("i->" + myArrayList.get(i));
        }
    }
}
