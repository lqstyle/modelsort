package com.example.leetcode.linkedList;

import java.util.Objects;

/**
 * 时间复杂度O（n）,空间复杂度O(1) 不依赖其他的数据结构
 */

public class PalindLinkedlistO1Memory {

    public static void main(String[] args) {
        Node<Integer> node = buildLinkedList();

        System.out.println(palind(node));
    }

    private static boolean palind(Node<Integer> node) {
        if (Objects.isNull(node) || Objects.isNull(node.next)) {
            return false;
        }
        //1 定义快慢指针，遍历链表 找到中间位置和最后位置
        Node n1 = node;
        Node n2 = node;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next; //中间位置
            n2 = n2.next.next; //最右边位置
        }
        System.out.println(node);
        //2 逆序中间位置右边的链表

        // 获取需要逆序的第一个节点
        n2 = n1.next;
        //断开中间位置以前的链表
        n1.next = null;
        // 暂存下一个元素的临时节点
        Node n3 = null;
        while (n2 != null) {
            // 获取当前遍历元素的下一个节点
            n3 = n2.next;
            // 当前元素的next指向需要指定的节点
            n2.next = n1;
            // 需要指定的前驱节点后移 remove
            n1 = n2;
            // 遍历的节点指定当前遍历元素的下一个节点 remove
            n2 = n3;
        }
        System.out.println(node);
        System.out.println(n1);

        n3 = n1; //保存最右侧指针，后面逆序需要使用
        n2 = node; //最左侧指针
        boolean result = true;
        //3 判断中间位置左右的节点数据是否相同 此刻n1是最由此指针，n2是最左侧指针
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                result = false;
            }
            if (!result) {
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //4 还原链表,针对右侧的链表进行修改
        n1 = n3.next;
        //断开逆序指针
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        System.out.println("链表还原后" + node);
        //5 输出结果
        return result;
    }

    private static Node<Integer> buildLinkedList() {
        Node<Integer> node = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(1);
        Node<Integer> node4 = new Node<>(0);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node;
    }

}
