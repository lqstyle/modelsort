package com.example.leetcode.mytree;

import java.util.ArrayList;
import java.util.List;

// 深度优先遍历
public class MyDfsTree extends TreeNode {


    // leetcode 144 二叉树先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    // 中序遍历  94
    public List<Integer> middleorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        midorder(root, result);
        return result;
    }

    private void midorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        preorder(root.left, result);
        result.add(root.val);
        preorder(root.right, result);
    }


    // 后序遍历 145
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        preorder(root.left, result);
        preorder(root.right, result);
        result.add(root.val);
    }

}
