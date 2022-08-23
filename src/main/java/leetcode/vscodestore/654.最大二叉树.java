/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);

    }

    public TreeNode build(int[] nums, int lo, int hi) {
        if(lo > hi) return null;

        int index = -1, maxVal = Integer.MIN_VALUE;
        for(int i=lo; i<=hi; i++) {
            int curr = nums[i];
            if(curr > maxVal) {
                index = i;
                maxVal = curr;
            }
        }

        TreeNode node = new TreeNode(maxVal);
        node.left = build(nums, lo, index - 1);
        node.right = build(nums, index + 1, hi);
        return node;
    }
}
// @lc code=end

