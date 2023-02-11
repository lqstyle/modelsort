package com.example.cdmodelsort.sort;

/**
 * TestLinkedList - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/16 16:24
 */
public class TestLinkedList {

  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(3);
    ListNode three = new ListNode(2);
    one.next =two;
    two.next=three;
    reversePrint(one);
  }

  public static int[] reversePrint(ListNode head) {
    if (head == null) {
      return new int[0];
    }
    ListNode node = head;
    ListNode pre = null;
    ListNode tmp = null;
    int j = 0;
    while (node != null) {
      tmp = node.next;
      node.next = pre;
      pre = node;
      node = tmp;
      j++;
    }

    tmp = pre;
    int[] result = new int[j];
    j = 0;
    while (tmp != null) {
      result[j] = tmp.val;
      tmp = tmp.next;
    }
    return result;
    // 还原链表

  }

  static class ListNode {
    public int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
