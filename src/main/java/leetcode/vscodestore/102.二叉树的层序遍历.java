/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return new LinkedList<>();

        List<List<Integer>> res = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            
            int size = queue.size();

            List<Integer> curLevel = new LinkedList<>();

            for(int i=0; i<size; i++) {

                TreeNode curr = queue.poll();
                curLevel.add(curr.val);
                if(curr.left != null) {
                    queue.offer(curr.left);
                }

                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            
            res.add(curLevel);

        }

        return res;

    }
}
// @lc code=end

