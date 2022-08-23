/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<>();

        return build(1, n);

    }

    public List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if(lo > hi) {
            res.add(null);
            return res;
        }

        for(int i=lo; i<=hi; i++) {

            List<TreeNode> leftTrees = build(lo, i-1);
            List<TreeNode> rightTrees = build(i+1, hi);

            for(TreeNode left : leftTrees) {
                for(TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
// @lc code=end

