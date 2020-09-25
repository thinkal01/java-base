package com.note.Tree.RBTree;

import com.note.tools.printer.BinaryTrees;
import org.junit.Test;

@SuppressWarnings("unused")
public class RBTree01 {

    @Test
    public void test3() {
        Integer data[] = new Integer[]{
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
            System.out.println("【添加" + data[i] + "】");
            BinaryTrees.println(rb);
            System.out.println("---------------------------------------");
        }
    }

    @Test
    public void test4() {
        Integer data[] = new Integer[]{
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }

        BinaryTrees.println(rb);

        for (int i = 0; i < data.length; i++) {
            rb.remove(data[i]);
            System.out.println("---------------------------------------");
            System.out.println("【删除" + data[i] + "】");
            BinaryTrees.println(rb);
        }
    }

    @Test
    public void test5() {
        Integer data[] = {55, 38, 80, 25, 46, 76, 88, 17, 33, 50, 72};
        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);

        // rb.add(52);
        // BinaryTrees.println(rb);
        // rb.add(10);
        // BinaryTrees.println(rb);

        BinaryTrees.println(rb);
    }
}
