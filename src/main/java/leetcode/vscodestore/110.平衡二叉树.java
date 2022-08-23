/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {

        maxDepth(root);
        return isBalance;

    }

    public boolean isBalance = true;

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        if(!isBalance) {
            return -1;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(Math.abs(left-right) > 1) {
            isBalance = false;
        }

        return Math.max(left, right) + 1;
    }

}
// @lc code=end

