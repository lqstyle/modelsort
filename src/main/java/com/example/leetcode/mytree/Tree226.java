package com.example.leetcode.mytree;

/**
 * //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //
 * //
 * //输入：root = [4,2,7,1,3,6,9]
 * //输出：[4,7,2,9,6,3,1]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //
 * //
 * //输入：root = [2,1,3]
 * //输出：[2,3,1]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：root = []
 * //输出：[]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 树中节点数目范围在 [0, 100] 内
 * // -100 <= Node.val <= 100
 * //
 * //
 * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1758 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 * /**
 * * Definition for a binary tree node.
 * * public class TreeNode {
 * *     int val;
 * *     TreeNode left;
 * *     TreeNode right;
 * *     TreeNode() {}
 * *     TreeNode(int val) { this.val = val; }
 * *     TreeNode(int val, TreeNode left, TreeNode right) {
 * *         this.val = val;
 * *         this.left = left;
 * *         this.right = right;
 * *     }
 * * }
 */
public class Tree226 extends TreeNode {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
    }
}
