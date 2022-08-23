/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.sum = targetSum;
        traverse(root);
        return res;
    }

    int  curVal= 0;
    int sum;
    LinkedList<Integer> tackList = new LinkedList<>();
    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }

        curVal += root.val;
        tackList.add(root.val);
        if(root.left == null && root.right == null) {
            if(curVal == sum) {
                List<Integer> list = new LinkedList(tackList);
                res.add(list);
            }
        }

        traverse(root.left);
        traverse(root.right);

        curVal -= root.val;
        tackList.removeLast();
    }

}
// @lc code=end

