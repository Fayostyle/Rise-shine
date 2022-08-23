/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if(root == null) return res;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();

            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if(flag) curLevel.addLast(curr.val);
                else curLevel.addFirst(curr.val);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);

                
                
            }
            flag = ! flag;
            res.add(curLevel);
        }

        return res;

    }
}
// @lc code=end

