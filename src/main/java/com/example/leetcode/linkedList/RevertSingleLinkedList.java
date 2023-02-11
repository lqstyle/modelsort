package com.example.leetcode.linkedList;

public class RevertSingleLinkedList {
    public static void main(String[] args) {
        // 构造链表
        Node<Integer> node = new Node<>(0);
        Node<Integer> head = node;
        Node temp = node;
        Node<Integer> nodeTemp;
        for (int i = 1; i < 10; i++) {
            nodeTemp = new Node<>(i);
            temp.next = nodeTemp;
            temp = nodeTemp;
        }
        System.out.println(node.toString());

        // 链表逆序 时间复杂度O(n) 空间复杂度O(1)
        Node<Integer> pre = null;
        Node<Integer> next;
        while (head != null) {
            //指针变换
            //获取head的下一指针所在的节点
            next = head.next;
            // 头结点指向 pre节点
            head.next = pre;
            // pre节点指向头节点
            pre = head;
            //头结点后移
            head = next;

        }
        System.out.println(pre.toString());
    }

}

class Node<T> {
    public T value;
    public Node next;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", next=" + next + '}';
    }
}