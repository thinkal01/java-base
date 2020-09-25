package com.note.collection.LinkedList.doubleLinked;

import com.note.collection.LinkedList.ILinkedList;

/**
 * 双链表最后一个结点next指针域指向头结点，头结点prev指针指向最后一个结点，则构成了双链表（Circular Doubly LinkedList）
 * 循环双链表,带空头结点(不含数据),循环链表可以不需要尾部指针,头结点head位置也可以获取到尾部结点位置。
 */
public class LoopHeadDILinkedList<T> implements ILinkedList<T> {

    protected DNode<T> head; //不带数据的头结点

    public LoopHeadDILinkedList() {
        this.head = new DNode<>();//初始化头结点
        this.head.next = head;
        this.head.prev = head;
    }

    /**
     * 传入一个数组,转换成链表
     * @param array
     */
    public LoopHeadDILinkedList(T[] array) {
        this();
        if (array != null && array.length > 0) {
            DNode<T> p = new DNode<>(array[0]);
            head.next = p;
            head.prev = p;
            p.prev = head;
            p.next = head;

            int i = 1;
            while (i < array.length) {
                p.next = new DNode<>(array[i++], p, head);
                head.prev = p.next;
                p = p.next;
            }
        }
    }


    @Override
    public boolean isEmpty() {
        return this.head.next == head;//循环双链表的后继指针指向自己说明是空链表
    }

    @Override
    public int length() {
        int length = 0;
        DNode<T> p = this.head.next;
        while (p != this.head) {
            length++;
            p = p.next;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index >= 0) {
            int j = 0;
            DNode<T> p = this.head.next;

            while (p != head && j < index) {
                j++;
                p = p.next;
            }

            if (p != head)
                return p.data;
        }

        return null;
    }

    /**
     * 根据index修改data
     * @param index
     * @param data
     * @return 返回被替换的data
     */
    @Override
    public T set(int index, T data) {
        if (data == null) {
            return null;
        }

        if (index >= 0) {
            int j = 0;
            DNode<T> p = this.head.next;

            while (p != head && j < index) {
                j++;
                p = p.next;
            }

            //如果不是头结点
            if (p != head) {
                T old = p.data;
                p.data = data;

                return old;
            }
        }

        return null;
    }

    /**
     * 根据index添加
     * 循环链表中无论是prev还是next都不存在空的情况,因此添加时
     * 无论是头部还是尾部还是中,都视为一种情况对待
     * @param index
     * @param data
     * @return
     */
    @Override
    public boolean add(int index, T data) {
        int size = length();
        if (data == null || index < 0 || index >= size)
            return false;

        int j = 0;
        DNode<T> p = this.head;
        //寻找插入点的位置
        while (p.next != head && j < index) {
            p = p.next;
            j++;
        }

        //创建新结点,如果index=3,那么插入的位置就是第4个位置
        DNode<T> q = new DNode<>(data, p, p.next);
        p.next.prev = q;
        p.next = q;

        return true;
    }

    /**
     * 尾部添加
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        if (data == null)
            return false;
        //创建新结点,让前继指针指向head.prev,后继指针指向head
        DNode<T> p = new DNode<>(data, head.prev, head);
        //更新tail后继指针的指向
        head.prev.next = p;
        head.prev = p;

        return true;
    }

    @Override
    public T remove(int index) {
        T old = null;
        int size = length();

        if (index < 0 || index >= size)
            return old;

        int j = 0;
        DNode<T> p = head.next;

        // 找到删除位置节点
        while (p != head && j < index) {
            j++;
            p = p.next;
        }

        if (p != head) {
            old = p.data;
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }

        return old;
    }

    @Override
    public boolean removeAll(T data) {
        boolean isRemove = false;

        if (data == null) {
            return isRemove;
        }

        DNode<T> p = head.next;
        while (p != head) {
            if (data.equals(p.data)) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                isRemove = true;
            }
            p = p.next;
        }

        return isRemove;
    }

    @Override
    public void clear() {
        head.prev = head;
        head.next = head;
    }

    @Override
    public boolean contains(T data) {
        if (data == null) {
            return false;
        }

        DNode<T> p = head.next;

        while (p != head) {
            if (data.equals(p.data)) {
                return false;
            }

            p = p.next;
        }

        return false;
    }

    @Override
    public String toString() {
        String str = "(";
        DNode<T> p = head.next;
        while (p != head) {
            str += p.data.toString();
            p = p.next;
            if (p != head)
                str += ", ";
        }
        return str + ")";
    }

}