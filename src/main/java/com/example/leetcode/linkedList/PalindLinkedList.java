package com.example.leetcode.linkedList;

import java.util.ArrayDeque;
import java.util.Objects;

public class PalindLinkedList {

    public static void main(String[] args) {
        Node<Integer> node = buildLinkedList();

        System.out.println(adjustLinkedList(node));

    }

    private static Node<Integer> buildLinkedList() {
        Node<Integer> node = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node3 = new Node<>(1);
        Node<Integer> node4 = new Node<>(0);
        node.next = node1;
        node1.next = node3;
        node3.next = node4;
        return node;
    }

    private static boolean adjustLinkedList(Node<Integer> node) {
        if (null == node) {
            return false;
        }
        ArrayDeque<Node<Integer>> arrayDeque = new ArrayDeque<>();
        Node head = node;
        Node<Integer> next;
        while (head != null) {
            arrayDeque.push(head);
            head = head.next;
        }
        while (node != null && arrayDeque.peek() != null) {
            if (!Objects.equals(node.value, arrayDeque.pop().value)) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}


