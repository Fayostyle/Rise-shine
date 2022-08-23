/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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

    List<TreeNode> res = new LinkedList<>();
    HashMap<String,Integer> memo = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root) {
        if(root == null) {
            return "#";
        }

        
        String left = traverse(root.left);
        String right = traverse(root.right);

        String cur = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(cur, 0);
        if(freq == 1) {
            res.add(root);
        }
        memo.put(cur, ++freq);
        return cur;

    }
}
// @lc code=end

