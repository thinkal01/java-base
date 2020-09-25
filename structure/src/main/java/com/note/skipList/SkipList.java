package com.note.skipList;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class SkipList<K, V> {
    /**
     * 最大层数
     */
    private static final int MAX_LEVEL = 32;
    /**
     * 元素层数+1概率
     */
    private static final double P = 0.25;
    /**
     * 元素数量
     */
    private int size;
    /**
     * 元素比较器
     */
    private Comparator<K> comparator;
    /**
     * 有效层数
     */
    private int level;
    /**
     * 链表头,不存放任何K-V
     */
    private Node<K, V> first;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node<>(null, null, MAX_LEVEL);
    }

    public SkipList() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        keyCheck(key);

        Node<K, V> node = first;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }

            // 找到返回当前值
            if (cmp == 0) return node.nexts[i].value;
        }

        return null;
    }

    public V put(K key, V value) {
        keyCheck(key);

        Node<K, V> node = first;
        // 插入节点所有前驱
        Node<K, V>[] prevs = new Node[level];

        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }

            if (cmp == 0) { // 节点是存在的
                V oldV = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldV;
            }

            prevs[i] = node;
        }

        // 新节点的层数
        int newLevel = randomLevel();
        // 添加新节点
        Node<K, V> newNode = new Node<>(key, value, newLevel);
        // 设置前驱和后继
        for (int i = 0; i < newLevel; i++) {
            if (i >= level) {
                first.nexts[i] = newNode;
            } else {
                // 新节点后继为前驱的后继
                newNode.nexts[i] = prevs[i].nexts[i];
                // 前驱的后继为新节点
                prevs[i].nexts[i] = newNode;
            }
        }

        // 节点数量增加
        size++;

        // 计算跳表的最终层数
        level = Math.max(level, newLevel);

        return null;
    }

    public V remove(K key) {
        keyCheck(key);

        Node<K, V> node = first;
        Node<K, V>[] prevs = new Node[level];
        // 元素是否存在
        boolean exist = false;

        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            prevs[i] = node;
            if (cmp == 0) exist = true;
        }

        if (!exist) return null;

        // 需要被删除的节点
        Node<K, V> removedNode = node.nexts[0];

        // 数量减少
        size--;

        // 设置后继
        for (int i = 0; i < removedNode.nexts.length; i++) {
            // 前驱节点后继指向删除节点后继
            prevs[i].nexts[i] = removedNode.nexts[i];
        }

        // 更新跳表的层数
        int newLevel = level;
        while (--newLevel >= 0 && first.nexts[newLevel] == null) {
            level = newLevel;
        }

        return removedNode.value;
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private void keyCheck(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null.");
        }
    }

    private int compare(K k1, K k2) {
        return comparator != null
                ? comparator.compare(k1, k2)
                : ((Comparable<K>) k1).compareTo(k2);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }

        @Override
        public String toString() {
            return key + ":" + value + "_" + nexts.length;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("一共" + level + "层").append("\n");
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> node = first;
            while (node.nexts[i] != null) {
                sb.append(node.nexts[i]);
                sb.append(" ");
                node = node.nexts[i];
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
