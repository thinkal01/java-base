package com.note.Tree.RBTree;

import com.note.tools.file.Files;
import com.note.tools.printer.BinaryTreeInfo;
import com.note.tools.printer.BinaryTrees;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class BST01 {

    @Test
    public void test1() {
        Integer data[] = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
    }

    @Test
    public void test2() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Person> bst1 = new BST<>();
        for (int i = 0; i < data.length; i++)
            BinaryTrees.println(bst1);

        BST<Person> bst2 = new BST<>((o1, o2) -> o2.getAge() - o1.getAge());
        for (int i = 0; i < data.length; i++) {
            bst2.add(new Person(data[i]));
        }

        BinaryTrees.println(bst2);
    }

    @Test
    public void test10() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100_0000; i++) {
            data.add((int) (Math.random() * 100_0000));
        }

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.size(); i++) {
            bst.add(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            bst.contains(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            bst.remove(data.get(i));
        }

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.size(); i++) {
            avl.add(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            avl.contains(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            avl.remove(data.get(i));
        }
    }

    @Test
    public void test11() {
        Integer data[] = new Integer[]{
                67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(avl);
            System.out.println("---------------------------------------");
        }

        for (int i = 0; i < data.length; i++) {
            avl.remove(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(avl);
            System.out.println("---------------------------------------");
        }

        BinaryTrees.println(avl);
    }

    @Test
    public void test3() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int) (Math.random() * 100));
        }

        String str = BinaryTrees.printString(bst);
        str += "\n";
        Files.writeToFile("F:/1.txt", str, true);

        // BinaryTrees.println(bst);
    }

    @Test
    public void test4() {
        BinaryTrees.println(new BinaryTreeInfo() {

            @Override
            public Object string(Object node) {
                return node.toString() + "_";
            }

            @Override
            public Object root() {
                return "A";
            }

            @Override
            public Object right(Object node) {
                if (node.equals("A")) return "C";
                if (node.equals("C")) return "E";
                return null;
            }

            @Override
            public Object left(Object node) {
                if (node.equals("A")) return "B";
                if (node.equals("C")) return "D";
                return null;
            }
        });
    }

    @Test
    public void test5() {
        BST<Person> bst = new BST<>();
        bst.add(new Person(10, "jack"));
        bst.add(new Person(12, "rose"));
        bst.add(new Person(6, "jim"));
        bst.add(new Person(10, "michael"));

        BinaryTrees.println(bst);
    }

    @Test
    public void test6() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5
        };

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

//		BST<Integer> bst = new BST<>();
//		for (int i = 0; i < 10; i++) {
//			bst.add((int)(Math.random() * 100));
//		}
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());

        // bst.levelOrderTraversal();
		
		/*
		 *       7
		 *    4    9
		    2   5
		 */

//		bst.levelOrder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + element + "_ ");
//			}
//		});

//		bst.inorder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + (element + 3) + "_ ");
//			}
//		});

        // System.out.println(bst.height());
    }

    @Test
    public void test7() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);

        bst.remove(7);

        BinaryTrees.println(bst);
    }

    @Test
    public void test8() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 1
        };

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());
    }

    @Test
    public void test9() {
        Integer data[] = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);

        /*bst.preorder(new BST.Visitor<Integer>() {
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 2 ? true : false;
            }
        });
        System.out.println();*/

        bst.inorder(new BST.Visitor<Integer>() {
            public boolean visit(Integer element) {
                // System.out.print(element + " ");
                return element == 4 ? true : false;
            }
        });
        System.out.println();

        /*bst.postorder(new BST.Visitor<Integer>() {
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 4 ? true : false;
            }
        });
        System.out.println();

        bst.levelOrder(new BST.Visitor<Integer>() {
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 9 ? true : false;
            }
        });*/
    }

    class Person implements Comparable<Person> {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(int age) {
            this.age = age;
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person e) {
            return age - e.age;
        }

        @Override
        public String toString() {
            return age + "_" + name;
        }
    }

}
