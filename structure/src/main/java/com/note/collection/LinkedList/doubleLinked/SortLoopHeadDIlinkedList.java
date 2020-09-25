package com.note.collection.LinkedList.doubleLinked;

/**
 * 插入元素时，根据值大小寻找插入位置，插入值data必须是T或者T的父类而且实现了Comparable接口。
 * 排序循环双链表的实现，只需继承循环双链表并重写add方法
 */
public class SortLoopHeadDIlinkedList<T extends Comparable<? extends T>> extends LoopHeadDILinkedList<T> {
    /**
     * 顺序插入
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        if (data == null || !(data instanceof Comparable))
            throw new NullPointerException("data can\'t be null or data instanceof Comparable must be true");

        //这里需要转一下类型,否则idea编辑器上检验不通过.
        Comparable cmp = data;

        //如果data值比最后一个结点大,那么直接调用父类方法,在尾部添加.
        if (this.isEmpty() || cmp.compareTo(this.head.prev.data) > 0) {
            return super.add(data);
        }

        DNode<T> p = this.head.next;
        //查找插入点
        while (p != head && cmp.compareTo(p.data) > 0)
            p = p.next;

        DNode<T> q = new DNode<>(data, p.prev, p);
        p.prev.next = q;
        p.prev = q;

        return true;
    }

}