package com.example.leetcode.cdmodelsort.tree;

/**
 * RecursionTress - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/17 10:56
 */
public class RecursionTree {

    public static void main(String[] args) {
        TreeNode tree = buildTree();
        preIteratorTree(tree); // 1243
        middleIteratorTree(tree); // 4213
        postIteratorTree(tree); // 4231
    }

    public static TreeNode buildTree() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        return treeNode;
    }

    public static void preIteratorTree(TreeNode head) {
        if (head == null) {
            return;
        }

        System.out.println(head.val);
        preIteratorTree(head.left);
        preIteratorTree(head.right);
    }

    public static void middleIteratorTree(TreeNode head) {
        if (head == null) {
            return;
        }

        middleIteratorTree(head.left);
        System.out.println(head.val);
        middleIteratorTree(head.right);
    }

    public static void postIteratorTree(TreeNode head) {
        if (head == null) {
            return;
        }

        postIteratorTree(head.left);
        postIteratorTree(head.right);
        System.out.println(head.val);
    }

  static class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }
}


