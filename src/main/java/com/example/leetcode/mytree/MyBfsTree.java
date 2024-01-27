package com.example.leetcode.mytree;

import java.util.*;

public class MyBfsTree extends TreeNode {


    // 先序遍历 广度优先   根 ->左->右   入栈顺序 根  ->右 ->左


    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.push(root);

        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {

            TreeNode node = deque.pop();
            result.add(node.val);

            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
        return result;
    }


    // 中序遍历  左 -> 根 -> 右  左树一直入栈，左树为空，则弹出并取右树
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> dequem = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while (!dequem.isEmpty() && node != null) {
            if (node.left != null) {
                dequem.push(node);
                node = node.left;
            } else {
                node = dequem.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }


    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }


}
