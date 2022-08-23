/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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

    /**
    递归方法
     */
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new LinkedList<>();
    //     return traverse(root, list);
    // }

    // public List<Integer> traverse(TreeNode root, List<Integer> list) {
    //     if(root == null) {
    //         return list;
    //     }

    //     List<Integer> left = traverse(root.left, list);
    //     list.add(root.val);
    //     List<Integer> right = traverse(root.right, list);
    //     return list;
    // }

//==================================================================================================

    /**
    迭代方法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        return traverse(root, list, stack);
    }

    public List<Integer> traverse(TreeNode root, List<Integer> list, Stack<TreeNode> stack) {
        TreeNode visited = new TreeNode(-1);
        pushLeftBranch(root, stack);
        
        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();

            if((curr.left == null || curr.left == visited) && curr.right != visited) {
                //中序位置

                list.add(curr.val);

                pushLeftBranch(curr.right, stack);
            }

            if(curr.right == null || curr.right == visited) {

                visited = stack.pop();
            }


        }

        return list;

        
       
    }

    public void pushLeftBranch(TreeNode root, Stack<TreeNode> stack) {
        while(root != null) {

            //前序位置

            stack.push(root);
            root = root.left;
        }
    }
}
// @lc code=end

